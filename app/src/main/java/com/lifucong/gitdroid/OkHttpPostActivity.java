package com.lifucong.gitdroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import java.io.IOException;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class OkHttpPostActivity extends Activity {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    private String BASE_URL = "http://admin.syfeicuiedu.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_post);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_regist)
    public void onClick() {

        String url = BASE_URL + "/Handler/UserHandler.ashx?action=register";
        User user = new User(etUsername.getText().toString(), etPassword.getText().toString());

        //调用网络单例，发送一个请求
        NetPostClient.getInstance().register(user, url).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("hahaha", "响应失败了");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("hahaha", "响应成功了");
            }
        });

    }
}
