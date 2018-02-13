package com.wangcpp.appstore.presenter.impl;

import com.wangcpp.appstore.presenter.IBasePresenter;
import com.wangcpp.appstore.ui.IView;

import java.lang.ref.WeakReference;

/**
 * Created by WANGCPP on 2018/2/11.
 * BasePresenter 类
 */
public abstract class BasePresenter<V extends IView> implements IBasePresenter<V> {

    private WeakReference<V> weakReference = null;

    @Override
    public void onShow(V view) {
        weakReference = new WeakReference<>(view);
    }

    @Override
    public void onHide() {
        weakReference.clear();
        weakReference = null;
    }

    @Override
    public V getView() {
        if (null != weakReference) {
            return weakReference.get();
        }
        return null;
    }
}
