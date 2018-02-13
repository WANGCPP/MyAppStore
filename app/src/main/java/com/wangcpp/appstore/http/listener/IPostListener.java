package com.wangcpp.appstore.http.listener;

import com.wangcpp.appstore.presenter.bean.BaseReceptionBean;

/**
 * Created by WANGCPP on 2018/2/12.
 * post请求监听
 */
public interface IPostListener {

    /**
     * post请求成功
     */
    void onPostSuccess(BaseReceptionBean bean);

    /**
     * post请求失败
     */
    void onPostFailed();
}
