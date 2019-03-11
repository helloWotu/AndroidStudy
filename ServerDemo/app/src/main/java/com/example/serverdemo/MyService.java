package com.example.serverdemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "MyService";
    private DownloadBinder dbinder = new DownloadBinder();



    class DownloadBinder extends Binder {
        public void startDownload() {
            Log.d(TAG, "startDownload executed");
        }

        public int getProgress() {
            Log.d(TAG, "getProgress executed");
            return 0;
        }

    }

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return dbinder;
    }

    /**
     * 服务创建的时候开始调用
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: executed");
    }

    /**
     * 服务销毁的时候开始调用，当服务销毁时候，在这个方法里去回收那些不在使用的资源
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: executed");
    }

    /**
     * 通常情况下，如果我们希望服务一点启动就立刻去执行某个动作，就可以将逻辑写在这里面
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                //处理具体的逻辑

                stopSelf();
            }
        }).start();

        return super.onStartCommand(intent, flags, startId);
    }
}
