package com.example.myapplication.view.home;

import com.example.myapplication.base.BaseView;
import com.example.myapplication.bean.MovieData;

public interface IHomeView extends BaseView {


    void onGetDataSuccess(MovieData theaters,MovieData comingSoon);

}
