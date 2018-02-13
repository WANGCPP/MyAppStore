package com.wangcpp.appstore.presenter.bean;

import java.util.List;

/**
 * Created by WANGCPP on 2018/2/12.
 * 应用列表接收类 bean
 */
public class AppListBean extends BaseReceptionBean {
    // 5 results 返回结果列表(Object List)
    // 总条数
    private String sum;
    // 本次取得条数
    private String get;
    private List<AppBean> results;

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getGet() {
        return get;
    }

    public void setGet(String get) {
        this.get = get;
    }

    public List<AppBean> getResults() {
        return results;
    }

    public void setResults(List<AppBean> results) {
        this.results = results;
    }
}
