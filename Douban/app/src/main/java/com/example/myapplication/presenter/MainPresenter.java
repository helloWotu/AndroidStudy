package com.example.myapplication.presenter;

import com.example.myapplication.base.BaseObserver;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.MovieData;
import com.example.myapplication.view.MainView;

public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView baseView) {
        super(baseView);
    }


    public void getDataList() {

        addDisposable(apiServer.getInTheaters(), new BaseObserver<MovieData>(baseView) {
            @Override
            public void onSuccess(MovieData o) {
                baseView.onGetSuccse(o);
            }

            @Override
            public void onError(String msg) {
                baseView.showError(msg);
            }
        });
    }
}
