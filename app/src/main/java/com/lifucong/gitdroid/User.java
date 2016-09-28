package com.lifucong.gitdroid;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/9/27.
 */
public class User {

    /**
     * Password : 654321
     * UserName : qjd
     */

    @SerializedName("Password")
    private String password;
    @SerializedName("UserName")
    private String userName;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }
}
