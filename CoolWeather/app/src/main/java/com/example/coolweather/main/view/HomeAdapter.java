package com.example.coolweather.main.view;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.coolweather.R;
import com.example.coolweather.gson.Weather;


import java.util.List;

public class HomeAdapter extends BaseQuickAdapter<Weather.ResultBean.DataListBean, BaseViewHolder> {

    public HomeAdapter(int layoutResId,List data) {
        super(layoutResId,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Weather.ResultBean.DataListBean item) {
        helper.setText(R.id.person_home_title,item.getTitle()).addOnClickListener(R.id.person_home_title);
        Glide.with(mContext).load(item.getIcon()).into((ImageView) helper.getView(R.id.icon_imageView));

    }
}
