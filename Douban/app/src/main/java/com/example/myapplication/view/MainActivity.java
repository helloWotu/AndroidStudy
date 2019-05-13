package com.example.myapplication.view;

import androidx.annotation.NonNull;

import com.example.myapplication.view.home.HomeFragment;
import com.example.myapplication.view.hot.HotFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.bean.MovieData;
import com.example.myapplication.loading.Myloading;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.presenter.MainPresenter;


public class MainActivity extends BaseActivity<MainPresenter> implements MainView, View.OnClickListener {

    private Myloading mMyloading;

    private static final String TAG_HOME_FRAGMENT = "home_fragment";
    private static final String TAG_HOT_FRAGMENT = "hot_fragment";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    initHomeFragment();
                    return true;
                case R.id.navigation_dashboard:
                    initHotFragment();
                    return true;
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }
    };


    @Override
    public void initView() {
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        initHomeFragment();

        mMyloading = (Myloading)findViewById(R.id.ball_single);

    }

    private void initHomeFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.main_views,new HomeFragment(),TAG_HOME_FRAGMENT);
        transaction.commit();
    }

    private void initHotFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.main_views,new HotFragment(),TAG_HOT_FRAGMENT);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

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
    public void onGetSuccse(MovieData dataBean) {
        showtoast("获取成功:" + dataBean.getTitle());
    }
}
