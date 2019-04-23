package com.example.wisdombeijing.Fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import com.example.wisdombeijing.BaseFragment;

import java.util.ArrayList;

public class ContentAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = "MyFragmentPagerAdapter";
    private ArrayList<BaseFragment> mList;
    private Context mContext;

    public ContentAdapter(FragmentManager fm, Context context) {
        super(fm);

//            mList = mPagers;
        mList = new ArrayList<BaseFragment>();
        this.mContext = context;

    }

    public void setLists(ArrayList<BaseFragment> lists) {
        this.mList = lists;
    }

    public void UpdateList(ArrayList<BaseFragment> arrayList) {
        this.mList.clear();
        this.mList.addAll(arrayList);

        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Fragment getItem(int i) {
        return mList.get(i);
    }


    @Override
    public int getItemPosition(Object object) {
        // TODO Auto-generated method stub
        return PagerAdapter.POSITION_NONE;
    }



}
