package com.example.coolweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.coolweather.db.DaoUtils;
import com.example.coolweather.db.Province;
import com.example.coolweather.db.ProvinceDao;
import com.example.coolweather.util.CallBackUtil;
import com.example.coolweather.util.GreenDaoManager;
import com.example.coolweather.util.OkhttpUtil;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaoUtils.init(MainActivity.this);

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
