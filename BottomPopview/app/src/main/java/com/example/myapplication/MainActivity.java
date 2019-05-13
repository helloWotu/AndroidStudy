package com.example.myapplication;

import android.app.Dialog;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    private BottomPopupWindow addPopWindow;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.click_btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payMobile();
            }
        });

    }


    private void payMobile(){
        if(addPopWindow ==null) {
            addPopWindow = new BottomPopupWindow(this);
        }
        //设置popupWindow弹出窗体的背景
        addPopWindow.setBackgroundDrawable(new BitmapDrawable(null, ""));
        addPopWindow.showPopupWindow(mButton);
        addPopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                recoveryAlpha();
            }
        });
        if(addPopWindow.isShowing()) {
            // 产生背景变暗效果
            WindowManager.LayoutParams lp = this.getWindow()
                    .getAttributes();
            lp.alpha = 0.4f;
            this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            this.getWindow().setAttributes(lp);
        }
    }

    private void recoveryAlpha() {
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.alpha = 1f;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setAttributes(lp);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (addPopWindow != null) {
            addPopWindow.dismiss();
            addPopWindow = null;
        }
    }

    @Override
    protected void onDestroy() {
        if (addPopWindow != null) {
            addPopWindow.dismiss();
            addPopWindow = null;
        }
        super.onDestroy();
    }
    
}
