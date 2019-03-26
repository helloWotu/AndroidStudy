package com.example.personcenterdemo;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class PersonAdapter extends BaseQuickAdapter <Info, BaseViewHolder>{
    public PersonAdapter(int layoutResId , List data) {
        super(layoutResId,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Info item) {
        helper.setText(R.id.item_content,item.getContent());
        helper.setText(R.id.item_title,item.getTitle());
    }
}
