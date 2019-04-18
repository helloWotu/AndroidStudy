package com.example.wisdombeijing;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.wisdombeijing.Fragment.GovmentFragment;
import com.example.wisdombeijing.Fragment.HomeFragment;
import com.example.wisdombeijing.Fragment.NewsFragment;
import com.example.wisdombeijing.Fragment.SettingFragment;
import com.example.wisdombeijing.Fragment.SmartFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragment extends BaseFragment {


    @BindView(R.id.main_fragment_rg)
    RadioGroup radioGroup;
    @BindView(R.id.rb_home)
    RadioButton rb_home;
    @BindView(R.id.rb_govaffairs)
    RadioButton rb_govaffairs;
    @BindView(R.id.rb_news)
    RadioButton rb_news;
    @BindView(R.id.rb_smart)
    RadioButton rb_smart;
    @BindView(R.id.rb_setting)
    RadioButton rb_setting;
    @BindView(R.id.content_viewPager)
    ViewPager viewPager;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }



    @Override
    public View initView() {

        View view = View.inflate(mActivity, R.layout.main_fragment, null);
        ButterKnife.bind(this,view);
        setRadioButtonImg();

        contentAdapter contentAdapter = new contentAdapter(getChildFragmentManager());
        viewPager.setAdapter(contentAdapter);


        return view;
    }

    @Override
    public void initData() {


    }


     class contentAdapter extends FragmentPagerAdapter {

        private ArrayList<Fragment> mPagers = new ArrayList<Fragment>();
        public contentAdapter(FragmentManager fm) {
            super(fm);
            mPagers.add(new HomeFragment());
            mPagers.add(new NewsFragment());
            mPagers.add(new SmartFragment());
            mPagers.add(new GovmentFragment());
            mPagers.add(new SettingFragment());

        }

        @Override
        public int getCount() {
            return mPagers.size();
        }

        @Override
        public Fragment getItem(int i) {
            return mPagers.get(i);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void setRadioButtonImg() {

        resetRadioButtonImage(R.drawable.tab_home_selector, rb_home);
        resetRadioButtonImage(R.drawable.tab_gove_selector, rb_govaffairs);
        resetRadioButtonImage(R.drawable.tab_news_selector, rb_news);
        resetRadioButtonImage(R.drawable.tab_smart_selector, rb_smart);
        resetRadioButtonImage(R.drawable.tab_setting_selector, rb_setting);
    }

    /**
     * 重置RadioButton的图片的大小
     * @param drawableId
     * @param radioButton
     */
    private void resetRadioButtonImage(int drawableId, RadioButton radioButton) {
        Drawable drawable_news = getResources().getDrawable(drawableId);
        drawable_news.setBounds(0, 0, 70, 70);
        radioButton.setCompoundDrawables(null, drawable_news, null, null);
    }



}
