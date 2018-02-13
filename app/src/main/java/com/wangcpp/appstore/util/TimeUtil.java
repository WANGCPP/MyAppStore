package com.wangcpp.appstore.util;

import android.annotation.SuppressLint;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by WANGCPP on 2018/2/12.
 * 时间工具类
 */
public class TimeUtil {
    public static String transferLongToDate(Long millSec) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(millSec);
        return sdf.format(date);
    }
}
