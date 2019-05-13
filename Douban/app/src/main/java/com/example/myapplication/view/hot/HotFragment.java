package com.example.myapplication.view.hot;


import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;

public class HotFragment extends BaseFragment<HotPresenter> implements IHotView {


    @Override
    public void initData() {

    }

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_top, null);

        return view;
    }

    @Override
    protected HotPresenter createPresenter() {
        return null;
    }
}
