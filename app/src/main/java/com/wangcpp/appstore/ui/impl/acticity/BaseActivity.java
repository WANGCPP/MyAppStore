package com.wangcpp.appstore.ui.impl.acticity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wangcpp.appstore.presenter.IBasePresenter;
import com.wangcpp.appstore.ui.IView;

/**
 * Created by WANGCPP on 2018/2/11.
 * BaseActivity 类
 */
public abstract class BaseActivity<P extends IBasePresenter> extends AppCompatActivity implements IView {

    protected P mPresenter = null;

    protected abstract P initPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onShow(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onHide();
    }
}
