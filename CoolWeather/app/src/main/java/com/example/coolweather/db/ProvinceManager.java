package com.example.coolweather.db;

import android.content.Context;

import com.example.coolweather.util.BaseDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class ProvinceManager extends BaseDao<Province> {
    public ProvinceManager(Context context) {
        super(context);
    }

    private Province loadById(long id) {
       return daoSession.getProvinceDao().load(id);
    }

    private long getID(Province province) {
        return daoSession.getProvinceDao().getKey(province);
    }

    /**
     * 通过id查找
     * @param id
     * @return
     */
    private List<Province> getProvinceById(long id) {
        QueryBuilder queryBuilder = daoSession.getProvinceDao().queryBuilder();
        queryBuilder.where(ProvinceDao.Properties.Id.eq(id));
        int size = queryBuilder.list().size();
        if (size > 0) {
            return queryBuilder.list();
        }else  {
            return null;
        }
    }

    private void deleteByID(long id) {
        daoSession.getProvinceDao().deleteByKey(id);
    }

    private void deleteByIds(List ids) {
        daoSession.getProvinceDao().deleteByKeyInTx(ids);
    }




}
