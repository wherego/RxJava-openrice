package com.sihua.rxjava.application;

import android.app.Application;

/**
 * Created by sihuaxie on 17/5/2.
 */

public class OpenRiceApplication extends Application {

    private static OpenRiceApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
    public synchronized static OpenRiceApplication getInstance() {
        return instance;
    }
}
