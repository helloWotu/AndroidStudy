package com.example.notificationtest;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int PUSH_NOTIFICATION_ID = (0x001);
    private static final String PUSH_CHANNEL_ID = "PUSH_NOTIFY_ID";
    private static final String PUSH_CHANNEL_NAME = "PUSH_NOTIFY_NAME";
    private int pushNum = 0;
    private NotificationManager notificationManager;

    private ImageView myimageview;
    private Uri imageUri;
    public static final int TAKE_PHOTO = 1;
    private File captureFile;

    public MainActivity(NotificationManager notificationManager) {
        this.notificationManager = notificationManager;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button noticeBtn = (Button)findViewById(R.id.send_notice);
        noticeBtn.setOnClickListener(this);

        Button take_pic_btn = (Button)findViewById(R.id.take_pic);
        take_pic_btn.setOnClickListener(this);

        myimageview = (ImageView) findViewById(R.id.image_view);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_notice:

                /**
                 * 设置通知渠道
                 */
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel(PUSH_CHANNEL_ID,
                            PUSH_CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
                    if (notificationManager != null) {
                        notificationManager.createNotificationChannel(channel);
                    }
                }
                /**
                 * 创建通知并显示
                 */
                NotificationCompat.Builder builder = new NotificationCompat.Builder(this,PUSH_CHANNEL_ID);
                Intent notificationIntent = new Intent(this, NoticationActivity.class);
                notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
                builder.setContentTitle("通知标题")//设置通知栏标题
                        .setContentIntent(pendingIntent) //设置通知栏点击意图
                        .setContentText("通知内容")
                        .setNumber(++pushNum)
                        .setTicker("通知内容") //通知首次出现在通知栏，带上升动画效果的
                        .setWhen(System.currentTimeMillis())//通知产生的时间，会在通知信息里显示，一般是系统获取到的时间
                        .setSmallIcon(R.mipmap.ic_launcher)//设置通知小ICON
                        .setChannelId(PUSH_CHANNEL_ID)
                        .setDefaults(Notification.DEFAULT_ALL);

                Notification notification = builder.build();
                notification.flags |= Notification.FLAG_AUTO_CANCEL;
                if (notificationManager != null) {
                    notificationManager.notify(PUSH_NOTIFICATION_ID, notification);
                }

                break;


            case R.id.take_pic:
//                File outputImage = new File(getExternalCacheDir(),"output_image.jpg");
                takePhotos();


                break;
                default:
                    break;
        }
    }


    /**
     * 拍照
     */
    private void takePhotos() {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            return;
        }

        captureFile = new File(getExternalCacheDir(),"output_image.jpg");

        try {
            if (captureFile.exists()) {
                captureFile.delete();
            }
            captureFile.createNewFile();
        }catch (IOException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            imageUri = FileProvider.getUriForFile(this,getPackageName(),captureFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
        }else {
            intent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(captureFile));
        }
        startActivityForResult(intent,TAKE_PHOTO);
    }



}
