package com.example.mvpsearchweather.model;


import android.util.Log;

import com.example.mvpsearchweather.bean.WeatherBean;
import com.example.mvpsearchweather.presenter.IweatherPresenter;
import com.example.mvpsearchweather.view.CallBackUtil;
import com.example.mvpsearchweather.view.OkhttpUtil;
import com.google.gson.Gson;

import okhttp3.Call;

public class WeatherModel implements IweatherModel {

    @Override
    public void requestWeather(String cityNO, final IweatherPresenter weatherListener) {

        String url = "http://www.weather.com.cn/data/sk/101010100.html";
       OkhttpUtil.okHttpGet(url, new CallBackUtil.CallBackString() {
           @Override
           public void onFailure(Call call, Exception e) {
               weatherListener.onError();
           }

           @Override
           public void onResponse(String response) {

               Log.d("weatherModel", "onResponse: " + response);
               WeatherBean weatherBean = new Gson().fromJson(response,WeatherBean.class);
               weatherListener.onSuccess(weatherBean);
           }
       });




    }


}
