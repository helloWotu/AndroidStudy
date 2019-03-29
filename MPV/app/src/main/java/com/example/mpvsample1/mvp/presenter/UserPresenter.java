package com.example.mpvsample1.mvp.presenter;

import android.util.Log;

import com.example.mpvsample1.mvp.view.IUserView;
import com.example.mpvsample1.mvp.bean.UserBean;
import com.example.mpvsample1.mvp.model.IUserModel;
import com.example.mpvsample1.mvp.model.UserModel;

/**
 * (4)Presenter:它能拥有m和v层的接口实例
 * Presenter就能通过接口与View及Model进行交互了：
 * 主要就是save和load两个方法的具体逻辑，在两个方法中调用m和v层的接口中规定好的方法
 */
public class UserPresenter {


    private static final String TAG = "UserPresenter";

    private IUserModel mUserModel;
    private IUserView mUserView;

    //将带有具体方法实现的实例upcast成为接口
    public UserPresenter(IUserView view) {
        this.mUserView = view;
        this.mUserModel = new UserModel();
    }

    //此方法将view层获取的数据存入model层，且只用到了接口里的方法
    public void saveUser() {
        if (  (isEmpty(mUserView.getFirstName())) && (isEmpty(mUserView.getLastName())) ) {

            mUserModel.saveUser(mUserView.getID(),mUserView.getFirstName(),mUserView.getLastName());
            Log.d(TAG, "saveUser: 存储成功!");
            mUserView.clearText();
        }else  {
            Log.d(TAG, "saveUser: 存储失败!!!!");
        }
    }

    public void loadUser() {
        UserBean userBean = mUserModel.loadUser(mUserView.getID());
        if (userBean != null) {
            Log.d(TAG, "loadUser: 取出成功");
            mUserView.setFirstName(userBean.getmFirstName());
            mUserView.setLastName(userBean.getmLastName());
        }else  {
            Log.d(TAG, "loadUser: 取出失败!!!");
        }
    }

    private boolean isEmpty(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }else {
            return true;
        }
    }

}
