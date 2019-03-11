package com.example.serverdemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private TextView textView;
    private MyService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    public static final int UPDATE_TEXT = 1;

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TEXT:
                    textView.setText("cheng gong");
                    break;
                    default:
                        break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button change = (Button)findViewById(R.id.my_button);
        change.setOnClickListener(this);
        textView = (TextView)findViewById(R.id.my_textView);

        Button startBtn = (Button)findViewById(R.id.start_server);
        startBtn.setOnClickListener(this);

        Button stopBtn = (Button)findViewById(R.id.stop_server);
        stopBtn.setOnClickListener(this);

        Button binBtn = (Button)findViewById(R.id.bind_server);
        binBtn.setOnClickListener(this);

        Button unbindBtn = (Button)findViewById(R.id.unbind_server);
        unbindBtn.setOnClickListener(this);


        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "run: ");
            }
        }).start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_button:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
//                        textView.setText("nice");
                        Message message = new Message();
                        message.what = UPDATE_TEXT;
                        handler.sendMessage(message);
                    }

                }).start();

                break;

            case R.id.start_server:

                Intent startInten = new Intent(this,MyService.class);
                startService(startInten);

                break;
            case R.id.stop_server:

                Intent stopIntent = new Intent(this,MyService.class);
                stopService(stopIntent);

                break;

            case R.id.bind_server:
                Intent bindIntent = new Intent(this,MyService.class);
                bindService(bindIntent,connection,BIND_AUTO_CREATE); //绑定服务

                break;
            case R.id.unbind_server:
                unbindService(connection); //解绑服务

                break;
                default:
                    break;
        }

    }
}
