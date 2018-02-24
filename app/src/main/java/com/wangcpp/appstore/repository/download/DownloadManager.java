package com.wangcpp.appstore.repository.download;

import android.os.Environment;
import android.util.Log;

import com.wangcpp.appstore.repository.download.progress.ProgressListener;
import com.wangcpp.appstore.repository.download.progress.ProgressResponseBody;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.wangcpp.appstore.entity.ServerURL.URL_BASE;
import static com.wangcpp.appstore.entity.ServerURL.URL_DOWNLOAD_BASE;

/**
 * Created by wangcp on 18-2-23.
 * 下载管理器，负责所有下载相关业务
 * 单例模式
 */

public class DownloadManager {

    private final String TAG = DownloadManager.class.getSimpleName();

    private static DownloadManager downloadManager = null;

    public static DownloadManager getInstance() {
        if (null == downloadManager) {
            synchronized (DownloadManager.class) {
                if (null == downloadManager) {
                    downloadManager = new DownloadManager();
                }
            }
        }
        return downloadManager;
    }


    public void startDownload(final String url) {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(URL_DOWNLOAD_BASE);

        OkHttpClient client = new OkHttpClient.Builder() //设置拦截器
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        okhttp3.Response orginalResponse = chain.proceed(chain.request());

                        return orginalResponse.newBuilder()
                                .body(new ProgressResponseBody(orginalResponse.body(), new ProgressListener() {
                                    int progress;

                                    @Override
                                    public void onProgress(long current, long total, boolean done) { //子线程中回调
                                        progress = (int) (current * 100 / total);
                                        Log.d(TAG, "current = " + progress);
                                    }
                                }))
                                .build();
                    }
                })
                .build();

        final IDownLoadRequest iDownRequest = builder.client(client).build().create(IDownLoadRequest.class);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Call<ResponseBody> call = iDownRequest.downloadWithUrl("bytes=0-", url); //从头下载

                try {
                    Response<ResponseBody> response = call.execute(); //同步请求
                    if (response.isSuccessful()) {
                        Log.d(TAG, "server contacted and has file");
                        boolean status = writeResponseBodyToDisk(response.body());
                    } else {
                        Log.d(TAG, "server contact failed");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    private boolean writeResponseBodyToDisk(ResponseBody body) {
        try {
            // 目标存储路径
            File targetFile = new File("/sdcard/Download/test.apk");

            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];

                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(targetFile);

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1) {
                        break;
                    }

                    outputStream.write(fileReader, 0, read);

                    fileSizeDownloaded += read;

                }

                outputStream.flush();

                return true;
            } catch (IOException e) {
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * 监听下载进度回调
     */
    public interface PListener {

        /**
         * onLoading
         *
         * @param progress 当前进度
         */
        void onLoading(int progress);

        /**
         * 下载完成
         */
        void onFinished();

    }

}
