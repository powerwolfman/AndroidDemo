package com.lifucong.gitdroid;

import com.google.gson.Gson;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Administrator on 2016/9/27.
 */
public class NetPostClient implements UserApi {

    private static NetPostClient netPostClient;
    private final OkHttpClient okHttpClient;

    private NetPostClient() {

        //设置拦截
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //创建okhttpclient
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }

    //单例模式
    public static NetPostClient getInstance() {
        if (netPostClient == null) {
            netPostClient = new NetPostClient();
        }
        return netPostClient;
    }

    @Override
    public Call register(User user, String url) {

        //创建一个requestBody，
        RequestBody body = RequestBody.create(null, new Gson().toJson(user));
        //请求
        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        //返回一个Call
        return okHttpClient.newCall(request);
    }

    @Override
    public Call getData(String url) {

        Request request=new Request.Builder()
                .get()
                .url(url)
                .build();

        return okHttpClient.newCall(request);
    }
}
