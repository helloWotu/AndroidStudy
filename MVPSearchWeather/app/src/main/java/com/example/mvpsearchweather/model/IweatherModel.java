package com.example.mvpsearchweather.model;

import com.example.mvpsearchweather.presenter.IweatherPresenter;

public interface IweatherModel {

    void requestWeather(String cityNO, IweatherPresenter weatherListener);

}
