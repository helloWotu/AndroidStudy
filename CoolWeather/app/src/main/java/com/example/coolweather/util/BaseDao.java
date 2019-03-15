package com.example.coolweather.util;

import android.Manifest;
import android.content.Context;
import android.util.Log;

import com.example.coolweather.db.City;
import com.example.coolweather.db.DaoSession;
import com.example.coolweather.db.ProvinceDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * 将所有创建的表格相同的部分封装到这个BaseDao中
 * @param <T>
 */
public class BaseDao<T> {

    public static final String TAG = BaseDao.class.getSimpleName();
    public static final boolean DEBUG = true;
    public GreenDaoManager greenDaoManager;
    public DaoSession daoSession;

    public BaseDao(Context context) {
        greenDaoManager = GreenDaoManager.getInstance();
        greenDaoManager.init(context);
        daoSession = greenDaoManager.getDaoSession();
        greenDaoManager.setDebug(DEBUG);
    }


    /**************************数据库插入操作***********************/

    /**
     * 插入一个对象
     * @param obj
     * @return
     */
    public boolean insertObject(T obj) {
        boolean flag = false;
        try {
            flag = greenDaoManager.getDaoSession().insert(obj) != -1 ? true : false;
        }catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.toString());
        }

        return flag;
    }

    /**
     * 插入多个对象
     * @param objs
     * @return
     */
    public boolean insertMultObjects(final List<T> objs) {
        boolean flag = false;
        if (objs == null || objs.isEmpty()) {
            return false;
        }
        try {
            greenDaoManager.getDaoSession().runInTx(new Runnable() {
                @Override
                public void run() {
                    for (T obj : objs) {
                        greenDaoManager.getDaoSession().insertOrReplace(obj);
                    }
                }
            });
            flag = true;
        }catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.toString() );
            flag = false;
        }finally {

        }

        return flag;
    }


    /**************************数据库更新操作***********************/

    public void updateObject(T obj) {
        if (obj == null) {
            return;
        }
        try {
            greenDaoManager.getDaoSession().update(obj);
        }catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.toString());
        }
    }

    public void updateMultObjects(final List<T> objs, Class cls) {
        if (objs == null || objs.isEmpty()) {
            return;
        }
        try {
            daoSession.getDao(cls).updateInTx(new Runnable() {
                @Override
                public void run() {
                    for (T obj : objs) {
                        daoSession.update(obj);
                    }
                }
            });
        }catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.toString() );
        }
    }

    /**************************数据库删除操作***********************/

    public boolean deleteAll(Class cls) {
        boolean flag = false;
        try {
            greenDaoManager.getDaoSession().deleteAll(cls);
            flag = true;
        }catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.toString() );
            flag = false;
        }

        return flag;
    }

    public boolean deleteMultObjects(final List<T> objs, Class cls) {
        if (objs == null || objs.isEmpty()) {
            return false;
        }

        boolean flag = false;
        try {
            daoSession.getDao(cls).deleteInTx(new Runnable() {
                @Override
                public void run() {
                    for (T obj : objs) {
                        daoSession.delete(obj);
                    }
                }
            });
            flag =  true;
        }catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.toString() );
            flag = false;
        }

        return flag;
    }

    /**************************数据库查询操作***********************/

    public String getTableName(Class cls) {
        return daoSession.getDao(cls).getTablename();
    }

//    public boolean isExitObject(long id,Class cls) {
//        QueryBuilder<T> qb = (QueryBuilder<T>) daoSession.getDao(cls).queryBuilder();
//        qb.where(daoSession.getDao(cls).getProperties().
//        long len =  qb.buildCount().count();
//        return len>0;
//    }

    public T queryById(long id,Class cls) {
        return (T) daoSession.getDao(cls).load(id);
    }

    public List<T> queryObjects(Class cls,String where,String...params) {
        Object obj = null;
        List<T> objects = null;

        try{
            obj = daoSession.getDao(cls);
            if (obj == null) {
                return null;
            }
            objects = daoSession.getDao(cls).queryRaw(where,params);
        }catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.toString() );
        }
        return objects;
    }


    /**************************关闭数据库***********************/

    public void closeDataBase() {
        greenDaoManager.closeDaoSession();
        greenDaoManager.closeHelper();
    }

}
