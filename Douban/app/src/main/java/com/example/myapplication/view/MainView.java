package com.example.myapplication.view;

import com.example.myapplication.base.BaseView;
import com.example.myapplication.bean.MovieData;
import com.example.myapplication.bean.Movieinfo;

public interface MainView extends BaseView {
   void onGetSuccse(MovieData dataBean);

//   void onGetSuccse(Movieinfo dataBean);
}

