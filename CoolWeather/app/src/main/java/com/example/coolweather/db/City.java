package com.example.coolweather.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

@Entity
public class City {
    @Id
    private long id;
    private String cityName;
    private String cityCode;
    private long countyID;
    @Generated(hash = 63875966)
    public City(long id, String cityName, String cityCode, long countyID) {
        this.id = id;
        this.cityName = cityName;
        this.cityCode = cityCode;
        this.countyID = countyID;
    }
    @Generated(hash = 750791287)
    public City() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCityName() {
        return this.cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String getCityCode() {
        return this.cityCode;
    }
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
    public long getCountyID() {
        return this.countyID;
    }
    public void setCountyID(long countyID) {
        this.countyID = countyID;
    }

}
