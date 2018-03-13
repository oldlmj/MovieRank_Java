package com.example.olo.movierank.MyApplication;

import android.content.Context;

/**
 * Created by OLO on 2018/2/26.
 */

public class MyApplicationContext {
    private static MyApplicationContext instance;

    private Context applicationContext;

    public static MyApplicationContext getInstance() {
        if (instance == null){
            throw new RuntimeException(MyApplicationContext.class.getSimpleName() + "has not been initialized!");
        }

        return instance;
    }

    public Context getApplicationContext() {
        return applicationContext;
    }

    public MyApplicationContext(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * 全局信息 只能調用一次
     */
    public static void init(Context applicationContext) {
        if (instance != null) {
            throw new RuntimeException(MyApplicationContext.class.getSimpleName() + " can not be initialized multiple times!");
        }
        instance = new MyApplicationContext(applicationContext);
    }

    public static boolean isInitialized() {
        return (instance != null);
    }
}
