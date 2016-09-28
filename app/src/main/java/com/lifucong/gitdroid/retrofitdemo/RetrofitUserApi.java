package com.lifucong.gitdroid.retrofitdemo;


import com.lifucong.gitdroid.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2016/9/28.
 */
public interface RetrofitUserApi {

    @GET("https://api.github.com/users/gqq")
    Call<ResponseBody> getData();

    @POST("/Handler/UserHandler.ashx?action=register")
    Call<ResponseBody> userRegister(@Body User user);
}
