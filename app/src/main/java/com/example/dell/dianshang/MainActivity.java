package com.example.dell.dianshang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Httputil httputil;
    private ListView lv;
    private String url="http://www.zhaoapi.cn/product/searchProducts?keywords=%E6%89%8B%E6%9C%BA&page=1&sort=0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        httputil=Httputil.Intence();
        lv=findViewById(R.id.list);
        httputil.getdata(url);
        httputil.sethttplistener(new Httputil.HttpListener() {
            @Override
            public void jsondatas(String s) {
                Gson gson=new Gson();
                User user = gson.fromJson(s, User.class);
                List<User.DataBean> data = user.getData();
                Mybase mybase=new Mybase(MainActivity.this,data);
                lv.setAdapter(mybase);
            }
        });
    }
}
