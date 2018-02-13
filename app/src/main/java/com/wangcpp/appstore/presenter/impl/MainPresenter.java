package com.wangcpp.appstore.presenter.impl;

import android.util.Log;

import com.wangcpp.appstore.AppStoreApplication;
import com.wangcpp.appstore.http.listener.IPostListener;
import com.wangcpp.appstore.presenter.IMainPresenter;
import com.wangcpp.appstore.presenter.bean.BaseReceptionBean;
import com.wangcpp.appstore.presenter.bean.LoginBean;
import com.wangcpp.appstore.repository.IPostRequestRepository;
import com.wangcpp.appstore.ui.IMainView;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by WANGCPP on 2018/2/11.
 * MainPresenter 类
 * <p>
 * 登录：向服务器发送登录Post请求，并获取登录结果，分发给ui
 */
public class MainPresenter extends BasePresenter<IMainView> implements IMainPresenter {

    private final String TAG = MainPresenter.class.getSimpleName();

    private IPostRequestRepository mRepository = null;

    public MainPresenter(IPostRequestRepository repository) {
        this.mRepository = repository;
    }

    @Override
    public void login() {
        mRepository.setOnPostListener(new IPostListener() {

            @Override
            public void onPostSuccess(BaseReceptionBean bean) {
                LoginBean loginBean = (LoginBean) bean;
                AppStoreApplication.token = loginBean.getToken();

                if (null != getView()) {
                    getView().onLoginResult(true);
                }
            }

            @Override
            public void onPostFailed() {
                if (null != getView()) {
                    getView().onLoginResult(false);
                }
            }
        });
        mRepository.postLogin(initLoginJson());

    }

    private String initLoginJson() {
        Map<String, Object> maps = new HashMap<>();
        maps.put("alfuscode", "");
        maps.put("appVersion", "1.0.2");
        maps.put("reqTime", "20180114215322");
        JSONObject jsonObject = new JSONObject(maps);
        return jsonObject.toString();
    }
}
