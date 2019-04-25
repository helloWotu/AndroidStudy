package com.example.myapplication.Units;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import com.example.myapplication.R;

public class Myloading extends LinearLayout {

    private boolean isStart = false;
    private SingleBall cradleBallOne;
    private SingleBall cradleBallTwo;
    private SingleBall cradleBallThree;
    private SingleBall cradleBallFour;
    private SingleBall cradleBallFive;

    private static final int DURATION = 400;
    private static final int SHAKE_DISTANCE = 2;
    private static final float PIVOT_X = 0.5f;
    private static final float PIVOT_Y = -3f;
    private static final int DEGREE = 30;

    public Myloading(Context context) {
        super(context);
        initView(context);
    }

    public Myloading(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public Myloading(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }


    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_singleball,this,true);
    }

    // inflate方法执行结束后执行这个方法


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        cradleBallOne = (SingleBall)findViewById(R.id.ball_one);
        cradleBallTwo = (SingleBall)findViewById(R.id.ball_two);
        cradleBallThree = (SingleBall)findViewById(R.id.ball_three);
        cradleBallFour = (SingleBall)findViewById(R.id.ball_four);
        cradleBallFive = (SingleBall)findViewById(R.id.ball_five);

        initAnim();
    }


    private RotateAnimation rotateLeftAnimation;//旋转动画效果
    private RotateAnimation rotateRightAnimation;
    private TranslateAnimation shakeLeftAnimation;// 位移动画效果
    private TranslateAnimation shakeRightAnimation;
    private void initAnim() {
        rotateRightAnimation = new RotateAnimation(0, -DEGREE, RotateAnimation.RELATIVE_TO_SELF, PIVOT_X, RotateAnimation.RELATIVE_TO_SELF, PIVOT_Y);
        rotateRightAnimation.setRepeatCount(1);
        rotateRightAnimation.setRepeatMode(Animation.REVERSE);
        rotateRightAnimation.setDuration(DURATION);
        rotateRightAnimation.setInterpolator(new LinearInterpolator());
        rotateRightAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (isStart)
                    startRightAnim();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        shakeLeftAnimation = new TranslateAnimation(0, SHAKE_DISTANCE, 0, 0);
        shakeLeftAnimation.setDuration(DURATION);
        shakeLeftAnimation.setInterpolator(new CycleInterpolator(2));

        rotateLeftAnimation = new RotateAnimation(0, DEGREE, RotateAnimation.RELATIVE_TO_SELF, PIVOT_X, RotateAnimation.RELATIVE_TO_SELF, PIVOT_Y);
        rotateLeftAnimation.setRepeatCount(1);
        rotateLeftAnimation.setRepeatMode(Animation.REVERSE);
        rotateLeftAnimation.setDuration(DURATION);
        rotateLeftAnimation.setInterpolator(new LinearInterpolator());
        rotateLeftAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (isStart) {
                    cradleBallTwo.startAnimation(shakeLeftAnimation);
                    cradleBallThree.startAnimation(shakeLeftAnimation);
                    cradleBallFour.startAnimation(shakeLeftAnimation);

                    cradleBallFive.startAnimation(rotateRightAnimation);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        shakeRightAnimation = new TranslateAnimation(0, -SHAKE_DISTANCE, 0, 0);
        shakeRightAnimation.setDuration(DURATION);
        shakeRightAnimation.setInterpolator(new CycleInterpolator(2));
        shakeRightAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if (isStart)
                    startLeftAnim();
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void startLeftAnim() {
        cradleBallOne.startAnimation(rotateLeftAnimation);
    }

    private void startRightAnim() {
        cradleBallTwo.startAnimation(shakeRightAnimation);
        cradleBallThree.startAnimation(shakeRightAnimation);
        cradleBallFour.startAnimation(shakeRightAnimation);
    }

    public void start() {
        if (!isStart) {
            isStart = true;
            startLeftAnim();
        }
    }

    public void stop() {
        isStart = false;
        cradleBallOne.clearAnimation();
        cradleBallTwo.clearAnimation();
        cradleBallThree.clearAnimation();
        cradleBallFour.clearAnimation();
        cradleBallFive.clearAnimation();
    }

    public boolean isStart() {
        return isStart;
    }

    public void setLoadingColor(int color) {
        cradleBallOne.setLoadingColor(color);
        cradleBallTwo.setLoadingColor(color);
        cradleBallThree.setLoadingColor(color);
        cradleBallFour.setLoadingColor(color);
        cradleBallFive.setLoadingColor(color);
    }
}
