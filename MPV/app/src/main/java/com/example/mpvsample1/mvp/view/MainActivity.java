package com.example.mpvsample1.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mpvsample1.R;
import com.example.mpvsample1.mvp.view.IUserView;
import com.example.mpvsample1.mvp.presenter.UserPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IUserView {

    private EditText text_ID;
    private EditText text_firstN;
    private EditText text_lastN;
    private Button btn_save;
    private Button btn_read;

    private UserPresenter mUserPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        mUserPresenter = new UserPresenter(this);

    }


    private void initViews() {
        text_ID = (EditText)findViewById(R.id.edit_id);
        text_firstN = (EditText)findViewById(R.id.edit_firstName);
        text_lastN = (EditText)findViewById(R.id.edit_lastName);

        btn_save = (Button)findViewById(R.id.btn_save);
        btn_save.setOnClickListener(this);

        btn_read = (Button)findViewById(R.id.btn_read);
        btn_read.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:

                mUserPresenter.saveUser();

                break;

            case R.id.btn_read:

                mUserPresenter.loadUser();

                break;

        }
    }

    @Override
    public void setFirstName(String firstName) {
        text_firstN.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        text_lastN.setText(lastName);
    }

    @Override
    public int getID() {
        return Integer.parseInt(text_ID.getText().toString());
    }

    @Override
    public String getFirstName() {
        return text_firstN.getText().toString();
    }

    @Override
    public String getLastName() {
        return text_lastN.getText().toString();
    }

    @Override
    public void clearText() {
        text_firstN.setText("");
        text_lastN.setText("");
        text_ID.setText("");
    }
}
