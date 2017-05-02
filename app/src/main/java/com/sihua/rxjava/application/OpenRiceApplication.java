package com.sihua.rxjava.application;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by sihuaxie on 17/5/2.
 */

public class OpenRiceApplication extends Application {

    private static OpenRiceApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Realm.init(this);
        RealmConfiguration config = new  RealmConfiguration.Builder()
                .name("openrice.realm")
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }
    public synchronized static OpenRiceApplication getInstance() {
        return instance;
    }
}
