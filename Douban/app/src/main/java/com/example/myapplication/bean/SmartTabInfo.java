package com.example.myapplication.bean;

import android.os.Bundle;

public class SmartTabInfo {
    public String mTitle;
    public Class mClazz;
    public Bundle mBundle;


    /**
     * 数据封装中classz用于通过反射获取Fragment的名字,
     * 然后再通过Fragment.instantiate(mContext,classz.getName())来获取相应的Fragment对象
     * @param title
     * @param clazz
     * @param bundle
     */
    public SmartTabInfo(String title, Class clazz, Bundle bundle) {
        mTitle = title;
        mClazz = clazz;
        mBundle = bundle;
    }



}
