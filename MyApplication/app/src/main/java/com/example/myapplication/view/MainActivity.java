package com.example.myapplication.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.presenter.CalculationPresenter;
import com.example.myapplication.utils.Calculatorcontract;

public class MainActivity extends AppCompatActivity implements Calculatorcontract.ICalculatorView {

    private TextView mTextView;
    private Button mButton;
    private Calculatorcontract.ICalculatorPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CalculationPresenter(this);

        mTextView = (TextView)findViewById(R.id.cal_textV);
        mButton = (Button) findViewById(R.id.cal_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add(1,2);
            }
        });
    }

    private void add(int a,int b) {
        mPresenter.add(a,b);
    }


    @Override
    public void result(int c) {
        mTextView.setText("结果:"+c);
    }

    @Override
    public void setPresenter(Calculatorcontract.ICalculatorPresenter presenter) {
        mPresenter = presenter;
    }
}
