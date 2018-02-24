package com.wangcpp.appstore.repository.impl;

import android.util.Log;

import com.wangcpp.appstore.http.IPostRequest;
import com.wangcpp.appstore.http.listener.IPostListener;
import com.wangcpp.appstore.presenter.bean.AppBean;
import com.wangcpp.appstore.presenter.bean.AppListBean;
import com.wangcpp.appstore.presenter.bean.DownUrlBase;
import com.wangcpp.appstore.presenter.bean.LoginBean;
import com.wangcpp.appstore.repository.IPostRequestRepository;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.wangcpp.appstore.entity.ServerURL.URL_BASE;

/**
 * Created by WANGCPP on 2018/2/12.
 * Post 网络请求仓库
 */
public class PostRequestRepository implements IPostRequestRepository {

    private final String TAG = PostRequestRepository.class.getSimpleName();

    private IPostListener mListener = null;

    @Override
    public void postLogin(String jsonString) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        IPostRequest postRequest = retrofit.create(IPostRequest.class);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), jsonString);

        postRequest.postLoginRequest(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {

                    Disposable disposable;

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe");
                        disposable = d;
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        Log.d(TAG, "onNext");
                        if (null != mListener) {
                            mListener.onPostSuccess(loginBean);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError");
                        if (null != mListener) {
                            mListener.onPostFailed();
                        }

                        if (disposable != null && !disposable.isDisposed()) {
                            disposable.dispose();
                        }
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                        if (disposable != null && !disposable.isDisposed()) {
                            disposable.dispose();
                        }
                    }
                });

    }

    @Override
    public void postQueryAppList(String jsonString) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        IPostRequest postRequest = retrofit.create(IPostRequest.class);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), jsonString);

        postRequest.postQueryAppList(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AppListBean>() {

                    Disposable disposable;

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe");
                        disposable = d;
                    }

                    @Override
                    public void onNext(AppListBean appListBean) {
                        Log.d(TAG, "onNext");
                        mListener.onPostSuccess(appListBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError");
                        mListener.onPostFailed();

                        if (disposable != null && !disposable.isDisposed()) {
                            disposable.dispose();
                        }
                        mListener = null;
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                        if (disposable != null && !disposable.isDisposed()) {
                            disposable.dispose();
                        }
                        mListener = null;
                    }
                });

    }

    @Override
    public void setOnPostListener(IPostListener listener) {
        this.mListener = listener;
    }

    @Override
    public void getDownUrl(String jsonString) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        IPostRequest postRequest = retrofit.create(IPostRequest.class);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), jsonString);

        postRequest.postGetDownloadUrl(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DownUrlBase>() {

                    Disposable disposable;

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onUrlSubscribe");
                        disposable = d;
                    }

                    @Override
                    public void onNext(DownUrlBase downUrlBase) {
                        Log.d(TAG, "onUrlNext");
                        mListener.onPostSuccess(downUrlBase);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onUrlError "+e.getMessage());
                        mListener.onPostFailed();

                        if (disposable != null && !disposable.isDisposed()) {
                            disposable.dispose();
                        }
                        mListener = null;
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onUrlComplete");
                        if (disposable != null && !disposable.isDisposed()) {
                            disposable.dispose();
                        }
                        mListener = null;
                    }
                });

    }

}
