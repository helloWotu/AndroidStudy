package com.example.myapplication.utils;

public class Calculatorcontract {

    public interface ICalculatorPresenter extends BasePresenter {
        void add(int a,int b);
    }

    public interface ICalculatorView extends BaseView<ICalculatorPresenter> {
        void result(int c);
    }

}
