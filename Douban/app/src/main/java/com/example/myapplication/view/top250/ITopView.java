package com.example.myapplication.view.top250;

import com.example.myapplication.base.BaseView;
import com.example.myapplication.bean.MovieData;

public interface ITopView extends BaseView {
    void getDataSuccess(MovieData movieData,boolean isLoadMore);

    void getDataError(String msg);
}
