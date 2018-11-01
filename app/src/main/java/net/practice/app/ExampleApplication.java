package net.practice.app;

import android.app.Application;


import org.litepal.LitePal;

import cn.jiguang.analytics.android.api.JAnalyticsInterface;

/**
 *
 */
public class ExampleApplication extends Application {

    private static ExampleApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;

        // 初始化极光统计
        JAnalyticsInterface.setDebugMode(true);
        JAnalyticsInterface.init(this);

        // 初始化数据库
        LitePal.initialize(this);
    }

    public static ExampleApplication getInstance() {
        return sInstance;
    }


}
