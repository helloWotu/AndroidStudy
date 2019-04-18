package com.example.wisdombeijing;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
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
    NoScrollViewPager mViewPager;


    private ArrayList<Fragment> mPagers = new ArrayList<Fragment>();
    private MainActivity mainActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }



    @Override
    public View initView() {

        View view = View.inflate(mActivity, R.layout.main_fragment, null);
        ButterKnife.bind(this,view);
        setRadioButtonImg();
        mainActivity = (MainActivity)mActivity;
        contentAdapter contentAdapter = new contentAdapter(getChildFragmentManager());
        mViewPager.setCanScoll(false);
        mViewPager.setAdapter(contentAdapter);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    case R.id.rb_home:
                       setToolTitle("首页");
                        mViewPager.setCurrentItem(0,false);
                        mainActivity.drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                        break;
                    case R.id.rb_news:
                        setToolTitle("新闻");
                        mViewPager.setCurrentItem(1,false);
                        mainActivity.drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                        break;
                    case R.id.rb_smart:
                        setToolTitle("智慧");
                        mViewPager.setCurrentItem(2,false);
                        mainActivity.drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                        break;
                    case R.id.rb_govaffairs:
                        setToolTitle("政务");
                        mViewPager.setCurrentItem(3,false);
                        mainActivity.drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                        break;
                    case R.id.rb_setting:
                        setToolTitle("设置");
                        mViewPager.setCurrentItem(4,false);
                        mainActivity.drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                        break;
                        default:

                }

            }

        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                BaseFragment fragment = (BaseFragment) mPagers.get(i);
                fragment.initData();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        BaseFragment home_fragment = (BaseFragment) mPagers.get(0);
        home_fragment.initData();

        return view;
    }

    private void setToolTitle(String title) {
        mainActivity.getTitleTextV().setText(title);
    }

    @Override
    public void initData() {


    }


     class contentAdapter extends FragmentPagerAdapter {

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
