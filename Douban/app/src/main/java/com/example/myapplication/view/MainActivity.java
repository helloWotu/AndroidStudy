package com.example.myapplication.view;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.myapplication.R;
import com.example.myapplication.Units.Myloading;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.bean.zhuantiList;
import com.example.myapplication.presenter.MainPresenter;


public class MainActivity extends BaseActivity<MainPresenter> implements MainView, View.OnClickListener {

    private TextView mTextMessage;
    private Myloading mMyloading;
    private Button start_ani_button;
    private Button end_ani_button;
    private Button get_data_button;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };


    private void getlist() {



    }

    @Override
    public void initView() {
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mMyloading = (Myloading)findViewById(R.id.ball_single);
        start_ani_button = (Button) findViewById(R.id.star_ball);
        end_ani_button = (Button)findViewById(R.id.end_ball);
        get_data_button = (Button)findViewById(R.id.getData);

        start_ani_button.setOnClickListener(this);
        end_ani_button.setOnClickListener(this);
        get_data_button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.star_ball:
                mMyloading.start();
                break;

            case R.id.end_ball:
                mMyloading.stop();
                break;

            case R.id.getData:
                presenter.getDataList();
                break;
                default:break;
        }
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onGetSuccse(zhuantiList.DataBean dataBean) {
        showtoast("获取成功:" + dataBean.getTitle());
    }
}
