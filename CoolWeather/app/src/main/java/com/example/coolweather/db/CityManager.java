package com.example.coolweather.db;

import android.content.Context;

import com.example.coolweather.util.BaseDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class CityManager extends BaseDao {
    public CityManager(Context context) {
        super(context);
    }

    private City loadById(long id) {
        return daoSession.getCityDao().load(id);
    }

    private long getID(City city) {
        return daoSession.getCityDao().getKey(city);
    }

    /**
     * 通过id查找
     * @param id
     * @return
     */
    private List<City> getCityById(long id) {
        QueryBuilder queryBuilder = daoSession.getCityDao().queryBuilder();
        queryBuilder.where(CityDao.Properties.Id.eq(id));
        int size = queryBuilder.list().size();
        if (size > 0) {
            return queryBuilder.list();
        }else  {
            return null;
        }
    }

    private void deleteByID(long id) {
        daoSession.getCityDao().deleteByKey(id);
    }

    private void deleteByIds(List ids) {
        daoSession.getCityDao().deleteByKeyInTx(ids);
    }


}
