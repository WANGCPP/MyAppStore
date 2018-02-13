package com.wangcpp.appstore;

import android.app.Application;
import android.util.Log;

/**
 * Created by WANGCPP on 2018/2/11.
 * Application 类
 */
public class AppStoreApplication extends Application {

    private final String TAG = AppStoreApplication.class.getSimpleName();

    //存储本次登录的token值
    public static String token = "";

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate()");
        super.onCreate();
    }
}
