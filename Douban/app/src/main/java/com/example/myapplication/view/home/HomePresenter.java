package com.example.myapplication.view.home;

import com.example.myapplication.base.BaseObserver;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.MovieData;
import com.example.myapplication.view.home.IHomeView;

public class HomePresenter extends BasePresenter<IHomeView> {

    MovieData threadsData;
    MovieData comingsoonData;

    private boolean isFinishThreads;
    private boolean isFinishComings;

    public HomePresenter(IHomeView baseView) {
        super(baseView);
    }


    public void requestThreadsAndComingData() {

        isFinishComings = false;
        isFinishThreads = false;
        requestHreadsData();
        requestComingData();

    }


    private void requestHreadsData() {

        addDisposable(apiServer.getInTheaters(), new BaseObserver<MovieData>(baseView) {
            @Override
            public void onSuccess(MovieData o) {
                threadsData = o;
                isFinishThreads = true;
                completeLoadData();
            }

            @Override
            public void onError(String msg) {
                baseView.showError(msg);
                isFinishThreads = true;
            }
        });

    }

    private void requestComingData() {
        addDisposable(apiServer.getComingSoon(), new BaseObserver<MovieData>(baseView) {
            @Override
            public void onSuccess(MovieData o) {
                comingsoonData = o;
                isFinishComings = true;
                completeLoadData();
            }

            @Override
            public void onError(String msg) {
                baseView.showError(msg);
                isFinishComings = true;
            }
        });

    }

    private void completeLoadData() {
        if (isFinishThreads && isFinishComings) {
            baseView.onGetDataSuccess(threadsData,comingsoonData);
        }
    }


}
