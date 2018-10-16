package net.practice.app;

import android.app.Application;


import cn.jiguang.analytics.android.api.JAnalyticsInterface;

/**
 *
 */
public class ExampleApplication extends Application {

    private static ExampleApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        JAnalyticsInterface.setDebugMode(true);
        JAnalyticsInterface.init(this);

        sInstance = this;
    }

    public static ExampleApplication getInstance() {
        return sInstance;
    }


}
