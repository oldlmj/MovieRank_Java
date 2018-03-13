package com.example.olo.movierank.MyApplication;

import android.app.Application;
import android.content.Context;

/**
 * Created by OLO on 2018/2/26.
 */

public class MyApplication extends Application {
    private static MyApplication mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        //LeakCanary.install(this);
        if (!MyApplicationContext.isInitialized()) {
            MyApplicationContext.init(getApplicationContext());
        }
    }
    public static Context getInstance() {
        if (mInstance == null) {
            mInstance = new MyApplication();
        }
        return mInstance;
    }
}
