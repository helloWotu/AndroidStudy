package com.example.wisdombeijing;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;

public class SplashActivity extends Activity {

    private ConstraintLayout splash_root;
    static private final String TAG = "SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splash_root = findViewById(R.id.splash_root);

        startAnimation();
    }


    private void startAnimation() {
        RotateAnimation animation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(1000);
        animation.setFillAfter(true);

        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setFillAfter(true);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setFillAfter(true);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(animation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);

        splash_root.startAnimation(animationSet);


        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d(TAG, "onAnimationEnd: 动画结束了");
                //如果第一次进来跳引导页，否则跳首页

                SharedPreferences sp = getSharedPreferences("config",MODE_PRIVATE);
                String key = "is_first_enter";
                boolean isfirstEnter = sp.getBoolean(key, true);

                Intent intent;
                if (isfirstEnter) {
//                    sp.edit().putBoolean(key,false).commit();
                    //新手引导页面
                    intent = new Intent(getApplicationContext(),GuideActivity.class);

                }else {
                    //首页
                    intent = new Intent(getApplicationContext(),MainActivity.class);

                }
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
