package com.wangcpp.appstore.presenter;

import com.wangcpp.appstore.ui.IView;

/**
 * Created by WANGCPP on 2018/2/11.
 * BasePresenter 接口类
 */
public interface IBasePresenter <V extends IView> {

    /**
     * view 画面显示
     */
    void onShow(V view);

    /**
     * view 画面消除
     */
    void onHide();

    /**
     * 获取view引用
     * @return view的弱引用
     */
    V getView();
}
