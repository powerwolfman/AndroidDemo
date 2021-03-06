package com.lifucong.gitdroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends Activity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.textView)
    TextView textView;
    @BindString(R.string.app_name)
    String name;
    @BindColor(R.color.colorPrimary)
    int color;
    String url = "https://api.github.com/users/gqq";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void setTextData() {
        textView.setText(name + "hehehehe");
        button.setBackgroundColor(color);
        NetPostClient.getInstance()
                .getData(url).enqueue(new UICallBack() {
            @Override
            public void onFailureInUI(Call call, IOException e) {
                Toast.makeText(MainActivity.this, "响应失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponseInUI(Call call, Response response) {
                Toast.makeText(MainActivity.this, "响应成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


//
//        HttpGet httpGet = new HttpGet();
//        httpGet.addHeader(new BasicHeader("", ""));
//        HttpClient httpClient = new DefaultHttpClient();
//        try {
//            HttpResponse httpResponse = httpClient.execute(httpGet);
//            if (httpResponse.getStatusLine().getStatusCode() == 200) {
//                httpResponse.getHeaders("");
//                HttpEntity httpEntity = httpResponse.getEntity();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//
//        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
//                .addInterceptor(interceptor)
//                .build();
//        Request request = new Request.Builder()
//                .get()
//                .url()
//                .build();
//        Call call = okHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.e("zzzzzzzz", "失败了");
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                Log.e("zzzzzzzz", "成功了");
//            }
//        });