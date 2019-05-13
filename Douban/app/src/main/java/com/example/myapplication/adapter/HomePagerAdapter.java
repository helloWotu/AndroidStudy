package com.example.myapplication.adapter;


import android.content.Context;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.base.BaseFragment;


import java.util.ArrayList;

public class HomePagerAdapter  extends FragmentPagerAdapter {

    /**
     * 注意事项:
     *  1,getItem中返回Fragment调用Fragment.instantiate(mContext,mSmartTabInfos.get(position).mClassz.getName());
     *  2,注意要重写getPageTitle才可以有标题
     *
     */

    private Context mContext;
    private ArrayList<BaseFragment> mSmartTabInfos;
    private FragmentManager mfm;

    public HomePagerAdapter(FragmentManager fm, Context context, ArrayList<BaseFragment> smartTabInfos) {
        super(fm);
        mfm = fm;
        mContext = context;
        mSmartTabInfos = smartTabInfos;
    }

    @Override
    public Fragment getItem(int i) {

        return mSmartTabInfos.get(i);
    }

    @Override
    public int getCount() {
        return mSmartTabInfos.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        BaseFragment fragment = (BaseFragment) mSmartTabInfos.get(position);
        return fragment.getTitle();
    }
}
