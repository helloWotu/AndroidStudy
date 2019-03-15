package com.example.coolweather.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.coolweather.MyApplication;
import com.example.coolweather.db.DaoMaster;
import com.example.coolweather.db.DaoSession;

import org.greenrobot.greendao.query.QueryBuilder;

public class GreenDaoManager {

    private static final String TAG = GreenDaoManager.class.getSimpleName();
    private static final String DB_NAME = "greenDao.db";

    private volatile static GreenDaoManager mGreenDaoManager;
    private static DaoMaster.DevOpenHelper mHelper;
    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;
    private static SQLiteDatabase db;
    private Context context;


    private GreenDaoManager() {

    }

    /**
     * 使用单例模式获得操作数据库的对象
     * @return
     */
    public static GreenDaoManager getInstance() {
        GreenDaoManager instance = null;
        if (mGreenDaoManager == null) {
            synchronized (GreenDaoManager.class) {
                if (instance == null) {
                    instance = new GreenDaoManager();
                    mGreenDaoManager = instance;
                }
            }
        }
        return mGreenDaoManager;
    }

    /**
     * 初始化Context对象
     * @param context
     */
    public void init(Context context) {
        this.context = context;
    }

    /**
     * 判断数据库是否存在，如果不存在则创建
     * @return
     */
    public DaoMaster getDaoMaster() {
        if (mDaoMaster == null) {
            mHelper = new DaoMaster.DevOpenHelper(context,DB_NAME,null);
            mDaoMaster = new DaoMaster(mHelper.getWritableDatabase());
        }
        return mDaoMaster;
    }


    /**
     * 完成对数据库的增删查找
     * @return
     */
    public DaoSession getDaoSession() {
        if (mDaoSession == null) {
            if (mDaoMaster == null) {
                mDaoMaster = getDaoMaster();
            }
            mDaoSession = mDaoMaster.newSession();
        }
        return mDaoSession;
    }

    /**
     * 设置debug模式开启或关闭，默认关闭
     * @param flag
     */
    public void setDebug(boolean flag) {
        QueryBuilder.LOG_SQL = flag;
        QueryBuilder.LOG_VALUES = flag;
    }


    /**
     * 关闭数据库
     */
    public void closeDaoSession() {
        if (mDaoSession != null) {
            mDaoSession.clear();
            mDaoSession = null;
        }
    }
    public void closeHelper() {
        if (mHelper != null) {
            mHelper.close();
            mHelper = null;
        }
    }


}
