package com.example.mpvsample1.mvp.model;

import com.example.mpvsample1.mvp.bean.UserBean;

/**
 * (3)Model接口：
 * 同样，Model也需要对这三个字段进行读写操作，并存储在某个载体内(这不是我们所关心的，
 * 可以存在内存、文件、数据库或者远程服务器，但对于Presenter及View无影响),定义IUserModel接口：
 */
public interface IUserModel {

    void saveUser(int id,String fristName,String lastName);

    UserBean loadUser(int id);

}
