package com.example.studycontentprovider;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        WindowManager vm = getWindowManager();
        float width = vm.getDefaultDisplay().getWidth();
        float height = vm.getDefaultDisplay().getHeight();

        Log.d(TAG, "onCreate: w + " + width + "height :" + height);


    }


}
