package com.wangcpp.appstore.http;

import com.wangcpp.appstore.presenter.bean.AppListBean;
import com.wangcpp.appstore.presenter.bean.DownUrlBase;
import com.wangcpp.appstore.presenter.bean.LoginBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import static com.wangcpp.appstore.entity.ServerURL.URL_APP_DOWN_URL;
import static com.wangcpp.appstore.entity.ServerURL.URL_LOGIN;
import static com.wangcpp.appstore.entity.ServerURL.URL_QUERYMULTI;

/**
 * Created by WANGCPP on 2018/2/12.
 * Retrofit
 * post请求接口
 */
public interface IPostRequest {

    @Headers({"Content-Type: application/json", "Accpet: application/json"}) // 需要添加头
    @POST(URL_LOGIN)
    Observable<LoginBean> postLoginRequest(@Body RequestBody requestBody); // 传入的参数为RequestBody

    @Headers({"Content-Type: application/json", "Accpet: application/json"}) // 需要添加头
    @POST(URL_QUERYMULTI)
    Observable<AppListBean> postQueryAppList(@Body RequestBody requestBody); // 传入的参数为RequestBody

    @Headers({"Content-Type: application/json", "Accpet: application/json"}) // 需要添加头
    @POST(URL_APP_DOWN_URL)
    Observable<DownUrlBase> postGetDownloadUrl(@Body RequestBody requestBody); // 传入的参数为RequestBody
}
