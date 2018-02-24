package com.wangcpp.appstore.repository.download;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by WANGCPP on 2018/1/15.
 * download请求接口
 */
public interface IDownLoadRequest {

    /**
     * @return ProgressResponseBody
     */
    @Streaming //表示返回的数据以流的形式返回,请求需开启新线程，并使用同步模式
//    @Headers("RANGE: bytes=0-") //需要在header中加入RANGE字段，添加固定header头
    @GET
    Call<ResponseBody> downloadWithUrl(@Header("RANGE") String rangeHeader, @Url String url);
}
