package com.example.myapplication.view.top250;

import com.example.myapplication.base.BaseObserver;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.MovieData;
import com.example.myapplication.view.top250.ITopView;

public class TopPresenter extends BasePresenter<ITopView> {
    public TopPresenter(ITopView baseView) {
        super(baseView);
    }

    public void requestTopData(int start, int count,boolean isLoadMore) {

        addDisposable(apiServer.getTop250(start,count), new BaseObserver<MovieData>(baseView) {
            @Override
            public void onSuccess(MovieData o) {
                baseView.getDataSuccess(o);
            }

            @Override
            public void onError(String msg) {
                baseView.getDataError(msg);
            }
        });

    }
}
