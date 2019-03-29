package com.example.mpvsample1.mvp.model;

import android.util.SparseArray;

import com.example.mpvsample1.mvp.bean.UserBean;

/**
 * 数据存储的模型层，只需要考虑怎么把数据存起来
 */
public class UserModel implements IUserModel{

    private SparseArray<UserBean> mUserArray = new SparseArray<UserBean>();

    public UserModel() {

    }

    @Override
    public void saveUser(int id, String fristName, String lastName) {
        mUserArray.append(id,new UserBean(fristName,lastName));
    }

    @Override
    public UserBean loadUser(int id) {

        if (mUserArray.indexOfKey(id) >= 0) {
            return mUserArray.get(id);
        }else  {
            UserBean userBean = new UserBean("notfound","notFound");
            return userBean;
        }

    }
}
