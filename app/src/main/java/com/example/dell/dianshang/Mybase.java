package com.example.dell.dianshang;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class Mybase extends BaseAdapter{
    private Context context;
    private List<User.DataBean> list;

    public Mybase(Context context, List<User.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if (view==null){
            view=View.inflate(context,R.layout.mybase,null);
            holder=new Holder();
            holder.im=view.findViewById(R.id.imageView);
            holder.t1=view.findViewById(R.id.textView);
            holder.t2=view.findViewById(R.id.textView2);
            holder.t3=view.findViewById(R.id.textView3);
            view.setTag(holder);
        }else {
            holder= (Holder) view.getTag();
        }
        ImageLoader.getInstance().displayImage(list.get(i).getDetailUrl(),holder.im,Myapplication.getoptions());
        holder.t1.setText(list.get(i).getTitle());
        holder.t2.setText(list.get(i).getCreatetime());
        holder.t3.setText(list.get(i).getPrice()+"");
        return view;
    }
    class Holder{
        ImageView im;
        TextView t1,t2,t3;
    }
}
