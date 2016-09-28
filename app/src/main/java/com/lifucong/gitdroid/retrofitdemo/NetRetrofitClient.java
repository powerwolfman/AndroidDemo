package com.lifucong.gitdroid.retrofitdemo;

import com.lifucong.gitdroid.User;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

/**
 * Created by Administrator on 2016/9/28.
 */
public class NetRetrofitClient implements RetrofitUserApi {

    private static NetRetrofitClient netRetrofitClient;
    private RetrofitUserApi userApi;
    private String BASE_URL = "http://admin.syfeicuiedu.com";

    private NetRetrofitClient() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        userApi = retrofit.create(RetrofitUserApi.class);
    }

    public static NetRetrofitClient getInstance() {
        if (netRetrofitClient == null) {
            netRetrofitClient = new NetRetrofitClient();
        }
        return netRetrofitClient;
    }

    @Override
    public Call<ResponseBody> getData() {
        return userApi.getData();
    }

    @Override
    public Call<ResponseBody> userRegister(@Body User user) {
        return userApi.userRegister(user);
    }
}
