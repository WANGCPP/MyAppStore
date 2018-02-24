package com.wangcpp.appstore.presenter.bean;

import java.util.List;

/**
 * Created by wangcp on 18-2-24.
 * 下载链接接收基类
 */

public class DownUrlBase extends BaseReceptionBean {
    private List<DownUrlBean> results;

    public List<DownUrlBean> getResults() {
        return results;
    }

    public void setResults(List<DownUrlBean> results) {
        this.results = results;
    }
}
