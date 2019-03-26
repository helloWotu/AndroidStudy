package com.example.coolweather.main.view;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Printer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.coolweather.MyApplication;
import com.example.coolweather.R;
import com.example.coolweather.gson.Weather;
import com.example.coolweather.util.CallBackUtil;
import com.example.coolweather.util.OkhttpUtil;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class MineActivity extends AppCompatActivity implements OnRefreshListener {

    private static final String TAG = "MineActivity";

    private RecyclerView mRecyclerView;
    private List<Weather.ResultBean.DataListBean> mDatas = new ArrayList<Weather.ResultBean.DataListBean>();
    private HomeAdapter mHomeAdapter;
    private int mCurrentPage = 1;
    private SmartRefreshLayout mSmartLayout;

    private final MyHandler myHandler = new MyHandler(this);

    /**
     * 解决Handler 内存泄漏在于两点：
     * 1.将Handler声明为静态内部类。因为静态内部类不会持有外部类的引用，所以不会导致外部类实例出现内存泄露。
     * 2.在Handler中添加对外部Activity的弱引用。由于Handler被声明为静态内部类，不再持有外部类对象的引用，
     * 导致无法在handleMessage()中操作Activity中的对象，所以需要在Handler中增加一个对Activity的弱引用。
     */

    private static class MyHandler extends Handler {
        private final WeakReference<MineActivity> mActivity;

        public MyHandler(MineActivity activity) {
            this.mActivity = new WeakReference<MineActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            MineActivity mineActivity = mActivity.get();
            if (mineActivity == null) {
                return;
            }
            // your code here


        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

//        Intent intent = getIntent();
//        intent.getIntExtra("sex",0);

        initViews();

        loadRequest(true);

    }

    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.person_home_recyclerview);
        mHomeAdapter = new HomeAdapter(R.layout.person_home_item,mDatas);

        TextView navTitle = (TextView) findViewById(R.id.nav_title_text);
        navTitle.setText("个人主页");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(mHomeAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));


        mHomeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Log.d(TAG, "onItemChildClick: ");
                Toast.makeText(MineActivity.this,"Click" + position,Toast.LENGTH_SHORT).show();
            }
        });


        mHomeAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Log.d(TAG, "onItemChildClick: ");
                Toast.makeText(MineActivity.this, "点击了标题" + position, Toast.LENGTH_SHORT).show();
            }
        });

        //添加头部视图
        mHomeAdapter.addHeaderView(getHeadView());

        mHomeAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                if (mCurrentPage == 4) {
                    mHomeAdapter.loadMoreEnd();
                    return;
                }
                mCurrentPage++;
                loadRequest(false);
            }
        },mRecyclerView);
//
//        mHomeAdapter.disableLoadMoreIfNotFullPage();

//        mHomeAdapter.setUpFetchEnable(true);
//        mHomeAdapter.setUpFetchListener(new BaseQuickAdapter.UpFetchListener() {
//            @Override
//            public void onUpFetch() {
//                Toast.makeText(MineActivity.this,"下拉刷新",Toast.LENGTH_SHORT).show();
//            }
//        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");


    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        mCurrentPage = 1;
        loadRequest(false);
    }


    private View getHeadView() {
        View headView = LayoutInflater.from(MineActivity.this).inflate(R.layout.head_section,null);
        return headView;
    }


    private void loadRequest(final boolean firstLoad) {

        final String url = "http://api.kaolafm.com/api/v4/personalCenterInfo";
        OkhttpUtil.okHttpGet(url, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                Toast.makeText(MyApplication.getmContext(),"网络请求失败",Toast.LENGTH_SHORT).show();
                mHomeAdapter.loadMoreFail();
            }

            @Override
            public void onResponse(String response) {
                if (firstLoad || mCurrentPage == 1) {
                    mDatas.clear();
                }
                Weather weather = new Gson().fromJson(response,Weather.class);
                List<List<Weather.ResultBean.DataListBean>> lists = weather.getResult().getDataList();
                for (List<Weather.ResultBean.DataListBean> list : lists) {
                    for (Weather.ResultBean.DataListBean bean : list) {
                        mDatas.add(bean);
                    }
                }

                if (mDatas.size() > 0 || !mDatas.isEmpty()) {
                    mHomeAdapter.loadMoreComplete();
                    mSmartLayout.finishRefresh();
                    mHomeAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    private void testHander() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                Message msg = Message.obtain();
                msg.what = 1;
                msg.obj = "hello";
                myHandler.sendMessage(msg);

            }
        });
        thread.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent  = getIntent();
        intent.putExtra("param","param" + MineActivity.class.toString());
        setResult(0,intent);
    }
}
