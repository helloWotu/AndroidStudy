package com.example.mpvsample1.mvp.view;


/**
 * (2)再来看看View接口：
 *      根据需求可知，save按钮按下后，会把ID、FirstName、LastName这三个EditText里的数据传给model进行储存，由于
 * 我们是mvp架构，所以是传给presenter层让它和model层打交道。所以要有读取view组件里数据的3个方法;
 *      load按钮按下后，读取id数值，然后传给p层，让它从m层取出对应的用户名密码，然后返回数据给v层并且显示出来，
 * 所以要有把text set进两个edittext里的方法。
 */
public interface IUserView {

    void setFirstName(String firstName);

    void setLastName(String lastName);

    int getID();

    String getFirstName();

    String getLastName();

    void clearText();

}
