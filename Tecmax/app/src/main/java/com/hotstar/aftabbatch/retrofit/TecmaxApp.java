package com.hotstar.aftabbatch.retrofit;

import android.app.Application;

import io.realm.Realm;

public class TecmaxApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
