package com.example.mvpsearchweather.presenter;

import com.example.mvpsearchweather.bean.WeatherBean;

public interface IweatherPresenter {

    void getWeather(String cityNO);

    void onSuccess(WeatherBean weatherBean);

    void onError();
}
