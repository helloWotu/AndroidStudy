package com.example.myapplication.view.home;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.adapter.HomePagerAdapter;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.bean.MovieData;
import com.example.myapplication.view.hot.HotFragment;
import com.example.myapplication.view.top250.Topfragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;

import androidx.viewpager.widget.ViewPager;

public class HomeFragment extends BaseFragment<HomePresenter> implements IHomeView{

//    private List<Object> mList = new ArrayList<Object>();
//    private RecyclerView mRecyclerView;
//    private String[] mTitles = new String[2];

    protected SmartTabLayout mSmartTabLayout;
    protected ViewPager  mViewPager;
    protected ArrayList<BaseFragment> mSmartTableInfos;

    @Override
    public void initData() {
        presenter.requestThreadsAndComingData();

        initSmartTabInfos();
        initSmartTablayoutAndViewPager();

    }

    /**
     * 初始化SmartTabInfos的集合信息
     * 标题
     * 创建的Fragment字节码
     * 传递的参数
     * 子类必须实现
     */
    protected void initSmartTabInfos() {
        //初始化Adapter需要使用的数据,标题,创建的Fragment对象,传递的参数
        mSmartTableInfos = new ArrayList<BaseFragment>();
        Bundle bundle = new Bundle();
        bundle.putString("args","我是资讯");

        HotFragment hotFragment = new HotFragment();
        hotFragment.setTitle("热映榜");
        mSmartTableInfos.add(hotFragment);
        Topfragment topfragment = new Topfragment();
        topfragment.setTitle("TOP250");
        mSmartTableInfos.add(topfragment);

    }

    private void initSmartTablayoutAndViewPager() {

        mViewPager.setAdapter(new HomePagerAdapter(getChildFragmentManager(),mActivity,mSmartTableInfos));
        mSmartTabLayout.setViewPager(mViewPager);

    }


    @Override
    public View initView() {

        View view = View.inflate(mActivity, R.layout.fragment_home, null);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mSmartTabLayout = (SmartTabLayout) view.findViewById(R.id.viewpagertab);



//        mRecyclerView = (RecyclerView) view.findViewById(R.id.home_recyclerView);
//        LinearLayoutManager manager = new LinearLayoutManager(mActivity);
//        manager.setOrientation(LinearLayoutManager.VERTICAL);
//        mRecyclerView.setLayoutManager(manager);

        return view;
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter(this);
    }

    //获取数据，刷新UI
    @Override
    public void onGetDataSuccess(MovieData theaters, MovieData comingSoon) {

//        mList.add(0,theaters);
//        mList.add(1,comingSoon);
//
//        mTitles[0] = theaters.getTitle();
//        mTitles[1] = comingSoon.getTitle();
//
//        HomeRecyclerViewAdapter homeAdapter = new HomeRecyclerViewAdapter(getActivity(),mList,mTitles);
//        mRecyclerView.setAdapter(homeAdapter);
    }
}
