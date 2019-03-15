package com.example.coolweather;

import com.example.coolweather.main.bean.TemperatureBean;

public interface MainContract {
    interface View extends BaseView<Presenter> {
        void showTemperature(TemperatureBean temperatureBean);
    }

    interface Presenter extends BasePresenter {
       void showPresentTemperature();
    }


}
