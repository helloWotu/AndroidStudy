package com.example.myapplication.Units;

import android.app.Application;



public class MyApplication extends Application {
    private static MyApplication myApplication;

    public static MyApplication getMyApplication() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;


    }
}
