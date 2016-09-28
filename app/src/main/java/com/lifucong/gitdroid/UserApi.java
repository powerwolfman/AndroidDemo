package com.lifucong.gitdroid;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/9/27.
 */
public interface UserApi {
    Call register(User user,String url);
    Call getData(String url);
}
