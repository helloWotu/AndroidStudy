package com.example.myapplication.api;


import com.example.myapplication.bean.zhuantiList;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface ApiServer {

    @GET("zhbj/10002/list_1")
    Observable<zhuantiList.DataBean> getlist();


    @Streaming
    @GET
    /**
     * 大文件官方建议用 @Streaming 来进行注解，不然会出现IO异常，小文件可以忽略不注入
     */
    Observable<ResponseBody> downloadFile(@Url String fileUrl);

    @Multipart
    @POST("user/register.do")
    Observable<String> register(@Part("phone") RequestBody phone, @Part("password") RequestBody password, @Part MultipartBody.Part image);

}
