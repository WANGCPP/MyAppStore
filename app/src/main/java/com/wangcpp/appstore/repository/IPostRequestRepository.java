package com.wangcpp.appstore.repository;

import com.wangcpp.appstore.http.listener.IPostListener;

/**
 * Created by WANGCPP on 2018/2/12.
 * Post 网络请求仓库 接口类
 */
public interface IPostRequestRepository {

    void postLogin(String jsonString);

    void postQueryAppList(String jsonString);

    void setOnPostListener(IPostListener listener);
}
