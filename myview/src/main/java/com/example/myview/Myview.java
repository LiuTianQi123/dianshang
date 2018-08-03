package com.example.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Myview extends LinearLayout{
    public Myview(Context context) {
        this(context,null);
    }

    public Myview(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Myview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs,defStyleAttr);
    }
    public interface Viewonclick{
        void leftonclick();
        void rightonclick();
    }
    public Viewonclick viewonclick;
    public void setViewonclick(Viewonclick viewonclick){
        this.viewonclick=viewonclick;
    }
    private void init(Context context,AttributeSet attrs, int defStyleAttr) {
        //引入布局文件
        View.inflate(context,R.layout.activity_main,this);
        TextView left=findViewById(R.id.lefttext);
        TextView right=findViewById(R.id.righttext);
        //引入属性文件
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Myview, defStyleAttr, 0);
        int color = typedArray.getColor(R.styleable.Myview_left_background, Color.GRAY);
        int color1 = typedArray.getColor(R.styleable.Myview_right_background, Color.GREEN);
        left.setBackgroundColor(color);
        right.setBackgroundColor(color1);
        left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                viewonclick.leftonclick();
            }
        });
        right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                viewonclick.rightonclick();
            }
        });
    }

}
