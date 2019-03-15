package com.example.coolweather.main.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.coolweather.MainContract;
import com.example.coolweather.main.bean.TemperatureBean;
import com.example.coolweather.main.model.TemperatureModel;

import org.greenrobot.greendao.annotation.NotNull;



/**
 * TemperaturePresenter实现了MainContract.Presenter接口，并在其构造器中调用mainView.setPresenter方法，
 * 把View注入到Presenter中。
 */
public class TemperaturePresenter implements MainContract.Presenter {

    @NotNull
    private final MainContract.View mMainView;

    private final TemperatureModel mTemperatureModel;

    public TemperaturePresenter(@NotNull MainContract.View mainView) {
        mMainView = mainView;
        mTemperatureModel = new TemperatureModel();
        mMainView.setpresenter(this);
    }

    @Override
    public void start() {
        showPresentTemperature();
    }

    @Override
    public void showPresentTemperature() {
        final Handler mTempHander = new Handler(Looper.getMainLooper());
        new Thread(){
            @Override
            public void run() {
                final TemperatureBean temperatureBean = mTemperatureModel.queryTemperature();
                mTempHander.post(new Runnable() {
                    @Override
                    public void run() {
                       mMainView.showTemperature(temperatureBean);
                    }
                });

            }
        }.start();

    }
}
