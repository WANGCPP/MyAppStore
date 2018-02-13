package com.wangcpp.appstore.ui;

import com.wangcpp.appstore.presenter.bean.AppBean;
import com.wangcpp.appstore.presenter.bean.AppListBean;

import java.util.List;

/**
 * Created by WANGCPP on 2018/2/11.
 * 应用商店 view接口类
 */
public interface IAppStoreView extends IView {

    void updateAllAppList(List<AppBean> appListBean);
}
