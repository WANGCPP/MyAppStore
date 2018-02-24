package com.wangcpp.appstore.repository;

import com.wangcpp.appstore.http.listener.IPostListener;
import com.wangcpp.appstore.presenter.bean.AppBean;

/**
 * Created by WANGCPP on 2018/2/12.
 * Post 网络请求仓库 接口类
 */
public interface IPostRequestRepository {

    /**
     * 登录
     * @param jsonString jsonBody
     */
    void postLogin(String jsonString);

    /**
     * 请求全部应用列表
     * @param jsonString jsonBody
     */
    void postQueryAppList(String jsonString);

    /**
     * 设定post请求监听
     * @param listener 监听对象
     */
    void setOnPostListener(IPostListener listener);

    /**
     * 获取Apk下载链接
     * @param jsonString jsonBody
     */
    void getDownUrl(String jsonString);
}
