package com.wangcpp.appstore.ui.impl.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangcpp.appstore.R;
import com.wangcpp.appstore.presenter.bean.AppBean;
import com.wangcpp.appstore.presenter.bean.AppListBean;
import com.wangcpp.appstore.presenter.impl.AppStorePresenter;
import com.wangcpp.appstore.repository.impl.PostRequestRepository;
import com.wangcpp.appstore.ui.IAppStoreView;
import com.wangcpp.appstore.ui.impl.adapter.AppStoreAdapter;

import java.util.List;

/**
 * Created by WANGCPP on 2018/2/11.
 * 应用商店列表界面
 */
public class AppStoreFragment extends BaseFragment<AppStorePresenter> implements IAppStoreView {

    private final String TAG = AppStoreFragment.class.getSimpleName();

    /**
     * 应用商店中的全部app信息列表
     */
    private List<AppBean> mAllAppList = null;


    //==================view==========
    private RecyclerView recyclerView = null;

    private AppStoreAdapter appStoreAdapter = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_appstore, container, false);



        mPresenter.queryAppList();

        initView(view);
        return view;
    }

    @Override
    protected AppStorePresenter initPresenter() {
        return new AppStorePresenter(new PostRequestRepository());
    }

    private void initView(View view){
        recyclerView = (RecyclerView) view.findViewById(R.id.recyc_appstore);
        appStoreAdapter = new AppStoreAdapter(getActivity());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //设置为垂直布局
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设定适配器
        recyclerView.setAdapter(appStoreAdapter);
    }

    @Override
    public void updateAllAppList(List<AppBean> appListBean) {
        mAllAppList = appListBean;
        appStoreAdapter.setAppList(mAllAppList);
    }
}
