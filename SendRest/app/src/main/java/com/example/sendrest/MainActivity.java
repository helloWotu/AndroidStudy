package com.example.sendrest;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private AnimationDrawable anim;
    private ImageView iv_anims;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendButton = (Button) findViewById(R.id.button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();

                sendOrderedBroadcast(intent,null,null,null,
                        1,"发送了一条有序广播",null);

            }
        });

        Button startBtn =  (Button)findViewById(R.id.button2);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (anim != null && !anim.isRunning()) {
                    anim.start();
                }
            }
        });


        Button stopBtn = (Button)findViewById(R.id.button3);
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (anim != null && anim.isRunning()) {
                    anim.stop();
                }
            }
        });

        iv_anims = (ImageView) findViewById(R.id.imageView_anim);

        iv_anims.setImageResource(R.drawable.drawable_anims);
        anim = (AnimationDrawable) iv_anims.getDrawable();

    }
}
