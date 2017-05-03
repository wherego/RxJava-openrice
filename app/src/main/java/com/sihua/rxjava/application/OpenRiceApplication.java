package com.sihua.rxjava.application;

import android.app.Application;

import com.sihua.rxjava.model.OAuthModel;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by sihuaxie on 17/5/2.
 */

public class OpenRiceApplication extends Application {

    private static OpenRiceApplication instance;
    private OAuthModel oAuthModel;

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

    public OAuthModel getoAuthModel() {
        return oAuthModel;
    }

    public void setoAuthModel(OAuthModel oAuthModel) {
        this.oAuthModel = oAuthModel;
    }
}
