package com.wangcpp.appstore.presenter.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by WANGCPP on 2018/2/12.
 * 存储App信息的Bean
 */
public class AppBean implements Serializable {
    private static final long serialVersionUID = -6785970326450403518L;
    private String appId;
    private String verId;
    private String appVersion;
    private String name;
    private String type;
    private String appIntro;
    private String appRate;
    private String appRateCount;
    private String appViewCount;
    private String appDownloadCount;
    private String appUninstallCount;
    private String isFree;
    private String price;
    private String dvprNickname;
    private String publicDate;
    private String verIntro;
    private String size;
    private String icon;
    private String snapShoot1;
    private String snapShoot2;
    private String snapShoot3;
    private String snapShoot4;
    private String appStatus;
    private String appState;

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

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAppIntro() {
        return appIntro;
    }

    public void setAppIntro(String appIntro) {
        this.appIntro = appIntro;
    }

    public String getAppRate() {
        return appRate;
    }

    public void setAppRate(String appRate) {
        this.appRate = appRate;
    }

    public String getAppRateCount() {
        return appRateCount;
    }

    public void setAppRateCount(String appRateCount) {
        this.appRateCount = appRateCount;
    }

    public String getAppViewCount() {
        return appViewCount;
    }

    public void setAppViewCount(String appViewCount) {
        this.appViewCount = appViewCount;
    }

    public String getAppDownloadCount() {
        return appDownloadCount;
    }

    public void setAppDownloadCount(String appDownloadCount) {
        this.appDownloadCount = appDownloadCount;
    }

    public String getAppUninstallCount() {
        return appUninstallCount;
    }

    public void setAppUninstallCount(String appUninstallCount) {
        this.appUninstallCount = appUninstallCount;
    }

    public String getIsFree() {
        return isFree;
    }

    public void setIsFree(String isFree) {
        this.isFree = isFree;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDvprNickname() {
        return dvprNickname;
    }

    public void setDvprNickname(String dvprNickname) {
        this.dvprNickname = dvprNickname;
    }

    public String getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(String publicDate) {
        this.publicDate = publicDate;
    }

    public String getVerIntro() {
        return verIntro;
    }

    public void setVerIntro(String verIntro) {
        this.verIntro = verIntro;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSnapShoot1() {
        return snapShoot1;
    }

    public void setSnapShoot1(String snapShoot1) {
        this.snapShoot1 = snapShoot1;
    }

    public String getSnapShoot2() {
        return snapShoot2;
    }

    public void setSnapShoot2(String snapShoot2) {
        this.snapShoot2 = snapShoot2;
    }

    public String getSnapShoot3() {
        return snapShoot3;
    }

    public void setSnapShoot3(String snapShoot3) {
        this.snapShoot3 = snapShoot3;
    }

    public String getSnapShoot4() {
        return snapShoot4;
    }

    public void setSnapShoot4(String snapShoot4) {
        this.snapShoot4 = snapShoot4;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }

    public String getPreVersion() {
        return preVersion;
    }

    public void setPreVersion(String preVersion) {
        this.preVersion = preVersion;
    }

    public String getIsContainAd() {
        return isContainAd;
    }

    public void setIsContainAd(String isContainAd) {
        this.isContainAd = isContainAd;
    }

    public String getIsContainCost() {
        return isContainCost;
    }

    public void setIsContainCost(String isContainCost) {
        this.isContainCost = isContainCost;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getCarPackage() {
        return carPackage;
    }

    public void setCarPackage(String carPackage) {
        this.carPackage = carPackage;
    }

    public String getCarMain() {
        return carMain;
    }

    public void setCarMain(String carMain) {
        this.carMain = carMain;
    }

    public List<Cost> getCosts() {
        return costs;
    }

    public void setCosts(List<Cost> costs) {
        this.costs = costs;
    }

    public String getAppState() {
        return appState;
    }

    public void setAppState(String appState) {
        this.appState = appState;
    }

    public RatelistBean getRatelist() {
        return Ratelist;
    }

    public void setRatelist(RatelistBean ratelist) {
        Ratelist = ratelist;
    }

    private String preVersion;
    private String isContainAd;
    private String isContainCost;
    private String factory;
    private String vtype;
    private String ctype;
    private String pattern;
    private String carPackage;
    private String carMain;
    private List<Cost> costs;

    public class Cost {
        private String costId;
        private String costType;
        private String costName;

        public String getCostId() {
            return costId;
        }

        public void setCostId(String costId) {
            this.costId = costId;
        }

        public String getCostType() {
            return costType;
        }

        public void setCostType(String costType) {
            this.costType = costType;
        }

        public String getCostName() {
            return costName;
        }

        public void setCostName(String costName) {
            this.costName = costName;
        }

        public String getCostPrice() {
            return costPrice;
        }

        public void setCostPrice(String costPrice) {
            this.costPrice = costPrice;
        }

        private String costPrice;
    }

    private RatelistBean Ratelist;

    public class RatelistBean implements Serializable {
        private String Rate1Count;
        private String Rate2Count;
        private String Rate3Count;
        private String Rate4Count;
        private String Rate5Count;

        public String getRate1Count() {
            return Rate1Count;
        }

        public void setRate1Count(String rate1Count) {
            Rate1Count = rate1Count;
        }

        public String getRate2Count() {
            return Rate2Count;
        }

        public void setRate2Count(String rate2Count) {
            Rate2Count = rate2Count;
        }

        public String getRate3Count() {
            return Rate3Count;
        }

        public void setRate3Count(String rate3Count) {
            Rate3Count = rate3Count;
        }

        public String getRate4Count() {
            return Rate4Count;
        }

        public void setRate4Count(String rate4Count) {
            Rate4Count = rate4Count;
        }

        public String getRate5Count() {
            return Rate5Count;
        }

        public void setRate5Count(String rate5Count) {
            Rate5Count = rate5Count;
        }

    }
}
