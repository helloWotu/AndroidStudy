package com.example.coolweather;

import android.app.Application;
import android.content.Context;

import com.example.coolweather.util.GreenDaoManager;

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();


    }

    public static Context getmContext() {
        return mContext;
    }

}
