package com.example.coolweather.db;

import android.content.Context;

public class DaoUtils {
    private static ProvinceManager provinceManager;
    private static CountyManager countyManager;
    private static CityManager cityManager;

    private static Context context;


    public static void init(Context context) {
        DaoUtils.context = context.getApplicationContext();
    }

    public static ProvinceManager getProvinceInstance() {
        if (provinceManager == null) {
            provinceManager = new ProvinceManager(context);
        }
        return provinceManager;
    }

    public static CountyManager getCountyInstance() {
        if (countyManager == null) {
            countyManager = new CountyManager(context);
        }
        return countyManager;
    }

    public static CityManager getCityInstance() {
        if (cityManager == null) {
            cityManager = new CityManager(context);
        }
        return cityManager;
    }

}
