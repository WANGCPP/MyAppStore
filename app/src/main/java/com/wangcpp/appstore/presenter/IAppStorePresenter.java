package com.wangcpp.appstore.presenter;

import com.wangcpp.appstore.ui.IAppStoreView;

/**
 * Created by WANGCPP on 2018/2/11.
 * AppStorePresenter 接口类
 */
public interface IAppStorePresenter extends IBasePresenter<IAppStoreView> {

    /**
     * 请求应用商店中的应用列表
     */
    void queryAppList();
}
