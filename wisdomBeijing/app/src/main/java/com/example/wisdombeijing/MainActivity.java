package com.example.wisdombeijing;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wisdombeijing.Fragment.GalleryFragment;
import com.example.wisdombeijing.Fragment.NewsFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG_MAIN_FRAGMENT = "main_fragment";
    private Toolbar toolbar;
    private TextView titleTextV;
    public  DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //使用 toolbar 替换 actionbar，不然 onCreateOptionsMenu无法生效到 toolbar 上
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        titleTextV = (TextView) findViewById(R.id.toolbar_title);

        //给 toolbar 设置导航剪头，并绑定 DrawLayout，在滑动的时候执行动画
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);


        /**
         * 给NavigationView的菜单设置点击事件,
         * 点击事件处理之后调用drawer.closeDrawer(GravityCompat.START)关闭菜单
         * onBackPressed()方法里面可以判断 drawer.isDrawerOpen()来判断执行动作
         */
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initFragment();
    }


    private void initFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.main_views,new MainFragment(),TAG_MAIN_FRAGMENT);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void setTitleTextV(TextView titleTextV) {
        this.titleTextV = titleTextV;
    }

    public TextView getTitleTextV() {
        return titleTextV;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Toast.makeText(getApplicationContext(),"nav_camera",Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_gallery) {

            FragmentManager fm = getSupportFragmentManager();

            MainFragment mainFragment = (MainFragment) fm.findFragmentByTag(TAG_MAIN_FRAGMENT);

            ArrayList<BaseFragment> mPages = mainFragment.getPagers();
            mPages.set(1,new GalleryFragment());

           mainFragment.getContentAdapter().setLists(mPages);
           mainFragment.getContentAdapter().notifyDataSetChanged();

           titleTextV.setText("Gallery");

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
