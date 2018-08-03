package com.example.myview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Myview myview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        myview=findViewById(R.id.myview);
        myview.setViewonclick(new Myview.Viewonclick() {
            @Override
            public void leftonclick() {
                Toast.makeText(MainActivity.this,"点击了左",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightonclick() {
                Toast.makeText(MainActivity.this,"点击了右",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
