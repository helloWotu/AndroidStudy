package com.example.coolweather.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

@Entity
public class County {
    @Id
    private long id;
    private String countyName;
    private String countyCode;
    private long cityId;
    @Generated(hash = 1144647384)
    public County(long id, String countyName, String countyCode, long cityId) {
        this.id = id;
        this.countyName = countyName;
        this.countyCode = countyCode;
        this.cityId = cityId;
    }
    @Generated(hash = 1991272252)
    public County() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCountyName() {
        return this.countyName;
    }
    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }
    public String getCountyCode() {
        return this.countyCode;
    }
    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }
    public long getCityId() {
        return this.cityId;
    }
    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

}
