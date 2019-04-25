package com.example.myapplication.presenter;

import com.example.myapplication.base.BaseObserver;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.zhuantiList;
import com.example.myapplication.view.MainView;

public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView baseView) {
        super(baseView);
    }


    public void getDataList() {
        addDisposable(apiServer.getlist(), new BaseObserver<zhuantiList.DataBean>(baseView) {

            @Override
            public void onSuccess(zhuantiList.DataBean o) {
                baseView.onGetSuccse(o);
            }

            @Override
            public void onError(String msg) {
                baseView.showError(msg);
            }
        });
    }
}
