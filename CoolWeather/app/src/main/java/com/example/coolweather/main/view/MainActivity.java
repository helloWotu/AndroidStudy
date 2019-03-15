package com.example.coolweather.main.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coolweather.MainContract;
import com.example.coolweather.R;
import com.example.coolweather.db.DaoUtils;
import com.example.coolweather.db.Province;
import com.example.coolweather.main.bean.TemperatureBean;
import com.example.coolweather.main.presenter.TemperaturePresenter;
import com.example.coolweather.util.CallBackUtil;
import com.example.coolweather.util.OkhttpUtil;

import okhttp3.Call;

/**
 *  MainActivity实现了MainContract.View接口。MainContract.View继承自BaseView<T>接口，
 *  故MainActivity实现了setPresenter方法。MainActivity在onCreate回调中，
 *  以new MainPresenter(this)的方式实现了View和Presenter的互相注入。
 * ---------------------
 */
public class MainActivity extends AppCompatActivity implements MainContract.View , View.OnClickListener {

    private static final String TAG = "MainActivity";

    private Button showTempBtn;
    private TextView tempContentext;
    private MainContract.Presenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initGreenDao();
        new TemperaturePresenter(this);

        showTempBtn = (Button)findViewById(R.id.btn_click);
        showTempBtn.setOnClickListener(this);
        tempContentext = (TextView)findViewById(R.id.lab_text);


    }

    @Override
    public void setpresenter(MainContract.Presenter presenter) {
        mMainPresenter = presenter;
    }



    private void initGreenDao() {
        DaoUtils.init(MainActivity.this);
    }

    @Override
    public void showTemperature(TemperatureBean temperatureBean) {
        int celsius = temperatureBean.getDegree();
        String text = "presentTemperatureText : " + celsius;
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        tempContentext.setText(text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_click:
                mMainPresenter.start();
                break;
                default:
        }
    }

    private void testOKHttp() {
        String url = "https://www.baidu.com";
        OkhttpUtil.okHttpGet(url, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {

            }

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse: " + response);

            }

        });
    }

    private void testGreenDao() {

        final Province province = new Province(100,"湖南","101");
        DaoUtils.getProvinceInstance().insertObject(province);

        Button button = (Button)findViewById(R.id.btn_click);
        final TextView textView = findViewById(R.id.lab_text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Province province1 = DaoUtils.getProvinceInstance().queryById(100,Province.class);
                textView.setText(province1.getProvinceName());
            }
        });

    }

}

