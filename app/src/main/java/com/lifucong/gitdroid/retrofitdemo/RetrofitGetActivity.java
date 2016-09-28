package com.lifucong.gitdroid.retrofitdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.lifucong.gitdroid.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitGetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_get);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_reget)
    public void onClick() {
        NetRetrofitClient.getInstance().getData().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(RetrofitGetActivity.this, "响应成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RetrofitGetActivity.this, "响应失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
