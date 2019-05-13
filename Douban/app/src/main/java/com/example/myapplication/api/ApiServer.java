package com.example.myapplication.api;


import com.example.myapplication.bean.MovieData;
import com.example.myapplication.bean.Movieinfo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiServer {


    @GET("/v2/movie/us_box")
    Observable<Movieinfo> getHotMovie();

    @GET("/v2/movie/in_theaters")
    Observable<MovieData> getInTheaters();

    @GET("/v2/movie/coming_soon")
    Observable<MovieData> getComingSoon();

    @GET("/v2/movie/top250")
    Observable<MovieData> getTop250(@Query("start")int start,@Query("count")int count);

}
