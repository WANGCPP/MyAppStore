package com.wangcpp.appstore;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * Created by WANGCPP on 2018/2/11.
 * Application 类
 */
public class AppStoreApplication extends Application {

    private final String TAG = AppStoreApplication.class.getSimpleName();

    /**
     * 存储本次登录的Token值
     */
    public static String token = "";


    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate()");
        super.onCreate();
        initImageLoader(getApplicationContext());
    }

    /**
     * 缓存图片配置初始化
     *
     * @param context 上下文
     */
    private void initImageLoader(Context context) {

        File cacheDir = StorageUtils.getCacheDirectory(context);  // 缓存文件夹路径

        // 创建DisplayImageOptions对象
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();

        ImageLoaderConfiguration imageLoaderConfiguration = new ImageLoaderConfiguration.Builder(context)
                .defaultDisplayImageOptions(defaultOptions)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .threadPoolSize(3)
                .denyCacheImageMultipleSizesInMemory()
                .diskCache(new UnlimitedDiscCache(cacheDir))
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.FIFO)
                .build();

        ImageLoader.getInstance().init(imageLoaderConfiguration);

    }
}
