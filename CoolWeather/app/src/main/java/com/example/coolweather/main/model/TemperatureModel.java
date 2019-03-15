package com.example.coolweather.main.model;


import com.example.coolweather.main.bean.TemperatureBean;

import java.util.Random;

/**
 * MVP中的Model，在复杂的项目中，Model也可以指某个模块。
 */
public class TemperatureModel {
    public TemperatureBean queryTemperature() {

       try {
           Thread.sleep(2000);
       }catch (InterruptedException e) {
           e.printStackTrace();
       }

       int degree = 20 + new Random().nextInt(10);

       TemperatureBean temperatureBean = new TemperatureBean();
       temperatureBean.setDegree(degree);
        return temperatureBean;
    }


}
