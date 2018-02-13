package com.wangcpp.appstore.ui.impl.fragment;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.wangcpp.appstore.presenter.impl.BasePresenter;
import com.wangcpp.appstore.ui.IView;

/**
 * Created by WANGCPP on 2018/2/11.
 * BaseFragment 类
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IView {

    private Context mContext = null;

    private int fragmentId;

    protected P mPresenter = null;

    protected abstract P initPresenter();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        mPresenter = initPresenter();
        mPresenter.onShow(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPresenter.onHide();
    }

    public int getFragmentId() {
        return fragmentId;
    }

    public void setFragmentId(int fragmentId) {
        this.fragmentId = fragmentId;
    }
}
