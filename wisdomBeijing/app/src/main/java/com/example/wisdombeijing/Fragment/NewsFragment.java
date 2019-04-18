package com.example.wisdombeijing.Fragment;

import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.example.wisdombeijing.BaseFragment;
import com.example.wisdombeijing.R;
import com.example.wisdombeijing.Unit.CallBackUtil;
import com.example.wisdombeijing.Unit.OkhttpUtil;

import okhttp3.Call;


public class NewsFragment extends BaseFragment {

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_news, null);
        return view;
    }

    @Override
    public void initData() {
        Log.d("NewsFragment", "NewsFragment initData: ");

        getNetworkData();
    }

    private void getNetworkData() {

        final String url = "https://www.baidu.com/";
        OkhttpUtil.okHttpGet(url, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {

            }

            @Override
            public void onResponse(String response) {
                Toast.makeText(mActivity,response,Toast.LENGTH_SHORT).show();
            }
        });

    }


}
