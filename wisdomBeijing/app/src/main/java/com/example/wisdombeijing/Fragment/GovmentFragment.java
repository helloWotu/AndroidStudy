package com.example.wisdombeijing.Fragment;

import android.util.Log;
import android.view.View;

import com.example.wisdombeijing.BaseFragment;
import com.example.wisdombeijing.MainActivity;
import com.example.wisdombeijing.R;

public class GovmentFragment extends BaseFragment {

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_gov, null);
        return view;
    }

    @Override
    public void initData() {
        Log.d("GovmentFragment", "GovmentFragmentinitData: ");
    }
}
