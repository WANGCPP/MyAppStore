package com.wangcpp.appstore.presenter.impl;

import android.util.Log;

import com.wangcpp.appstore.AppStoreApplication;
import com.wangcpp.appstore.http.listener.IPostListener;
import com.wangcpp.appstore.presenter.IAppStorePresenter;
import com.wangcpp.appstore.presenter.bean.AppBean;
import com.wangcpp.appstore.presenter.bean.AppListBean;
import com.wangcpp.appstore.presenter.bean.BaseReceptionBean;
import com.wangcpp.appstore.presenter.bean.DownUrlBase;
import com.wangcpp.appstore.presenter.bean.DownUrlBean;
import com.wangcpp.appstore.repository.IPostRequestRepository;
import com.wangcpp.appstore.repository.download.DownloadManager;
import com.wangcpp.appstore.ui.IAppStoreView;
import com.wangcpp.appstore.util.TimeUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WANGCPP on 2018/2/11.
 * 应用商店 presenter类
 * <p>
 * 请求应用商店中的应用列表
 * queryAppList()
 */
public class AppStorePresenter extends BasePresenter<IAppStoreView> implements IAppStorePresenter {

    private final String TAG = AppStorePresenter.class.getSimpleName();

    private IPostRequestRepository mRepository = null;


    //================数据==================
    /**
     * 应用商店中全部的app列表
     */
    private AppListBean allAppListBean = null;

    private List<AppBean> results;

    public AppStorePresenter(IPostRequestRepository requestRepository) {
        this.mRepository = requestRepository;
    }


    @Override
    public void queryAppList() {
        mRepository.setOnPostListener(new IPostListener() {
            @Override
            public void onPostSuccess(BaseReceptionBean bean) {
                allAppListBean = (AppListBean) bean;
                results = ((AppListBean) bean).getResults();
                if (null != getView()) {
                    getView().updateAllAppList(results);
                }
            }

            @Override
            public void onPostFailed() {

            }
        });
        mRepository.postQueryAppList(initQueryAppListJson());
    }

    private String initQueryAppListJson() {
        Map<String, Object> maps = new HashMap<>();
        maps.put("reqTime", TimeUtil.transferLongToDate(System.currentTimeMillis()));
        maps.put("token", AppStoreApplication.token);
        maps.put("types", null);
        maps.put("ps", (-1) + "");
        maps.put("pn", 1 + "");
        maps.put("sortType", null);
        maps.put("asc", 1 + "");
        JSONObject jsonObjectResult = new JSONObject(maps);
        String content = jsonObjectResult.toString();
        return jsonObjectResult.toString();
    }

    @Override
    public void getApk(AppBean appBean) {
        mRepository.setOnPostListener(new IPostListener() {
            @Override
            public void onPostSuccess(BaseReceptionBean bean) {
                DownUrlBase downUrlBase = (DownUrlBase) bean;
                DownUrlBean downUrlBean = downUrlBase.getResults().get(0);
                Log.d(TAG, "url = " + downUrlBean.getUrl());
                DownloadManager.getInstance().startDownload(downUrlBean.getUrl()); // 获取到下载链接后，开始下载

            }

            @Override
            public void onPostFailed() {

            }
        });

        mRepository.getDownUrl(initGetApkJson(appBean));
    }

    private String initGetApkJson(AppBean appBean) {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("appId", appBean.getAppId());
            jsonObject.put("verId", appBean.getVerId());
            jsonObject.put("version", appBean.getAppVersion());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(jsonObject);
        Map<String, Object> maps = new HashMap<>();
        maps.put("reqTime", TimeUtil.transferLongToDate(System.currentTimeMillis()));
        maps.put("token", AppStoreApplication.token);
        maps.put("apps", jsonArray);
        JSONObject jsonObjectResult = new JSONObject(maps);
        Log.d(TAG, jsonObjectResult.toString());
        return jsonObjectResult.toString();
    }
}
