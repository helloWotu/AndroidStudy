package com.example.studyservers;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Myconn con;
    private Iservice mBinder;
    private boolean isBind; //记录一个bool变量，防止重复解绑
    private MyService mService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this,MyService.class);
        con = new Myconn();
        bindService(intent,con,BIND_AUTO_CREATE);

        Button btn = findViewById(R.id.call_zheng);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mBinder.someMehold(100);
                mService.callBanZheng(10000);

            }
        });


    }



    private class Myconn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBinder = (Iservice) service;
            isBind = true;
            mService = mBinder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBind = false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isBind) {
            unbindService(con);
        }
    }
}
