package com.example.studyservers;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    
    
    private static final String TAG = MyService.class.toString();
    private Mybinder mybinder = new Mybinder();

    public class Mybinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }

        public void someMehold(int money) {
            callBanZheng(money);
        }
    }


    //如何调服务里面的方法
    public void callBanZheng(int money) {
        if (money > 1000) {
            Toast.makeText(getApplicationContext(),"钱够了，把证给办了",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(),"钱不够，找别人办吧",Toast.LENGTH_LONG).show();
        }
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return mybinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }
}
