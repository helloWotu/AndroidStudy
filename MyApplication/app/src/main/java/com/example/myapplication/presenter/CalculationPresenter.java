package com.example.myapplication.presenter;

import com.example.myapplication.model.CalculationModel;
import com.example.myapplication.utils.Calculatorcontract;

public class CalculationPresenter implements Calculatorcontract.ICalculatorPresenter {

    private Calculatorcontract.ICalculatorView mView;
    private CalculationModel mModel;

    public CalculationPresenter(Calculatorcontract.ICalculatorView view) {
        mView = view;
        mModel = new CalculationModel();
        mView.setPresenter(this);
    }

    @Override
    public void add(int a, int b) {
       int result = mModel.add(a,b);
       mView.result(result);
    }


}
