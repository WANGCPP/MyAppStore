package com.wangcpp.appstore.presenter.bean;

/**
 * 下载链接 实体
 *
 * @author jinlong
 */
public class DownUrlBean {

    // 3.1 url 下载地址
    // 3.2 package 包名
    // 3.3 mainActivity 主Activity类名
    // 3.4 appId 应用Id
    // 3.5 verId 版本Id
    // 3.6 name 应用名称
    // 3.7 version 版本号

    private String url;
    private String carpackage;
    private String icon;
    private String size;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCarpackage() {
        return carpackage;
    }

    public void setCarpackage(String carpackage) {
        this.carpackage = carpackage;
    }

    public String getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(String mainActivity) {
        this.mainActivity = mainActivity;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getVerId() {
        return verId;
    }

    public void setVerId(String verId) {
        this.verId = verId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    private String mainActivity;
    private String appId;
    private String verId;
    private String name;
    private String version;
}
