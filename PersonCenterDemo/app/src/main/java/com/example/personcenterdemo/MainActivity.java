package com.example.personcenterdemo;

import android.content.IntentFilter;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SwipeRefreshLayout swipeRefreshLayout;
    private IntentFilter intentFilter;

    private List<Info> list = new ArrayList<>();
    private RecyclerView recyclerView;
//    private PersonCenterAdapter adapter;
    private HeaderBottomAdapter headerBottomAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setRefreshing(true);
        //设置下拉时圆圈的颜色（可以由多种颜色拼成）
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light);

        //设置下拉时圆圈的背景颜色（这里设置成白色）
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.white);
        swipeRefreshLayout.setRefreshing(false);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.d(TAG, "onRefresh: ");
                refreshData();
            }
        });

        //初始化数据
        initDatas();
        //初始化视图
        initViews();

//        try {
//            //模拟网络请求2s
//            Thread.sleep(2000);
//        }catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                headerBottomAdapter.notifyDataSetChanged();
//                swipeRefreshLayout.setRefreshing(false);
//            }
//        });

    }

    private void refreshData() {
        Info info = new Info();
        info.setContent("新的");
        info.setTitle("新的标题");
        list.add(info);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //模拟网络请求2s
                    Thread.sleep(2000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        headerBottomAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();


    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);

//        adapter = new PersonCenterAdapter(this,list);
        headerBottomAdapter = new HeaderBottomAdapter(this,list);

        //配置 layoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);//设置方向
        recyclerView.setLayoutManager(layoutManager);

        //配置adapter
        recyclerView.setAdapter(headerBottomAdapter);
        headerBottomAdapter.setOnItemClickListener(new HeaderBottomAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                    String toastText = "点击了" + position;
                    Toast.makeText(getApplicationContext(),toastText,Toast.LENGTH_LONG).show();
                    Info info = new Info();
                    info.setTitle("地区"+index+1);
                    info.setContent("详细地区"+index+1);
                    list.set(position-1,info);
//                    headerBottomAdapter.notifyItemChanged(position);
                    headerBottomAdapter.updateData(list);
            }
        });

        /**
         * 如果列表数据更新了，需调用更新方法，传入新的list
         */
//        adapter.update(list);
    }


    private void initDatas() {
        index = 0;
        String[] titles = {"基本信息","昵称","性别","生日","地区","介绍","绑定信息","手机","邮箱","手机","邮箱"};
        String[] contents = {"","哈哈嘿嘿","男","1909-12-08","宁夏回族自治区","自我介绍","","158229289","zhaoC@163.com","158229289","zhaoC@163.com"};

        for (int i = 0; i <titles.length ;i++) {
            Info info = new Info();
            info.setTitle(titles[i]);
            info.setContent(contents[i]);
            list.add(info);
        }

    }



}
