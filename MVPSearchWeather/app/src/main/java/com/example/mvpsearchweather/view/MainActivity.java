package com.example.mvpsearchweather.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvpsearchweather.R;
import com.example.mvpsearchweather.bean.WeatherBean;
import com.example.mvpsearchweather.presenter.WeatherPresenter;

public class MainActivity extends AppCompatActivity implements IWeatherView{

    private TextView tv_city;
    private Button btn_call;
    private WeatherPresenter mpresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mpresenter = new WeatherPresenter(this);

        tv_city = findViewById(R.id.tv_city);
        btn_call = findViewById(R.id.callData);

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpresenter.getWeather("");
            }
        });

    }

    @Override
    public void setWeatherInfo(WeatherBean weatherBean) {
        tv_city.setText(weatherBean.getWeatherinfo().getCity());
    }
}
