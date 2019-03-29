package com.example.mpvsample1.mvp.bean;

/**
 * (1)首先我们需要一个UserBean，用来保存用户信息
 */
public class UserBean {

    private String mFirstName;
    private String mLastName;

    public UserBean (String mFirstName,String mLastName) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }
}
