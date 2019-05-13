package com.example.myapplication.loading;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.myapplication.R;

public class SingleBall extends View {

    private int loadingColor = Color.BLUE;
    private Paint mPaint;
    private int width;
    private int height;

    public SingleBall(Context context) {
        super(context);
        initView(null);
    }

    public SingleBall(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    public SingleBall(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }


    // 初始化View，应用自定义属性
    private void initView(AttributeSet attrs) {
        if (attrs != null) {
            // 在这里获取我们自定义的各个属性
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.SingleBall);
            loadingColor = typedArray.getColor(R.styleable.SingleBall_single_ball_color, Color.BLUE);
            typedArray.recycle();
        }
        //初始化画笔，设置颜色，类型等
        mPaint = new Paint();
        mPaint.setColor(loadingColor);
        mPaint.setStyle(Paint.Style.FILL);
        //防止边缘锯齿
        mPaint.setAntiAlias(true);
    }

    // 由于只要关注小球的大小，而且在xml中指定就可以，
    // 所以不需要重写onMeasure方法
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    // 用canvas画一个圆
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(width/2,height/2,width/2,mPaint);
    }

    //设置小球的颜色
    public void  setLoadingColor(int color) {
        loadingColor = color;
        mPaint.setColor(color);
        postInvalidate();
    }

    public int getLoadingColor() {
        return loadingColor;
    }

}
