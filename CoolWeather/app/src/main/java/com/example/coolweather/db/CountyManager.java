package com.example.coolweather.db;

import android.content.Context;

import com.example.coolweather.util.BaseDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class CountyManager extends BaseDao {
    public CountyManager(Context context) {
        super(context);
    }

    private County loadById(long id) {
        return daoSession.getCountyDao().load(id);
    }

    private long getID(County county) {
        return daoSession.getCountyDao().getKey(county);
    }

    /**
     * 通过id查找
     * @param id
     * @return
     */
    private List<County> getCountyById(long id) {
        QueryBuilder queryBuilder = daoSession.getCountyDao().queryBuilder();
        queryBuilder.where(CountyDao.Properties.Id.eq(id));
        int size = queryBuilder.list().size();
        if (size > 0) {
            return queryBuilder.list();
        }else  {
            return null;
        }
    }

    private void deleteByID(long id) {
        daoSession.getCountyDao().deleteByKey(id);
    }

    private void deleteByIds(List ids) {
        daoSession.getCountyDao().deleteByKeyInTx(ids);
    }


}
