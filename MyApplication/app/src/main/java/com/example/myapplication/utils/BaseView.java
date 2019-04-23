package com.example.myapplication.utils;

public interface BaseView<P extends BasePresenter> {
    void setPresenter(P presenter);
}
