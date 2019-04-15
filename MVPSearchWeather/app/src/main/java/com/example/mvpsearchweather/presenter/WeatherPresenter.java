package com.example.mvpsearchweather.presenter;

import android.view.View;

import com.example.mvpsearchweather.bean.WeatherBean;
import com.example.mvpsearchweather.model.IweatherModel;
import com.example.mvpsearchweather.model.WeatherModel;
import com.example.mvpsearchweather.view.IWeatherView;

public class WeatherPresenter implements IweatherPresenter {

    private IweatherModel mWeatherModel;
    private IWeatherView mWeatherView;

    public WeatherPresenter(IWeatherView view) {
        mWeatherView =  view;
        mWeatherModel = new WeatherModel();
    }

    @Override
    public void getWeather(String cityNO) {
        mWeatherModel.requestWeather(cityNO,this);
    }

    @Override
    public void onSuccess(WeatherBean weatherBean) {
        mWeatherView.setWeatherInfo(weatherBean);
    }

    @Override
    public void onError() {

    }



}
