package com.example.dell.dianshang;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Httputil {
    private HttpListener httpListener;
    private static Httputil httputil;
    public static Httputil Intence(){
        if (httputil==null){
            httputil=new Httputil();
        }
        return httputil;
    }
    public void getdata(String url){
      Myasy myasy=new Myasy();
      myasy.execute(url);
    }
    class Myasy extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... strings) {
            String s="";
            try {
                URL url=new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setConnectTimeout(5000);
                urlConnection.setReadTimeout(5000);
                int code = urlConnection.getResponseCode();
                if (code==200){
                    InputStream inputStream = urlConnection.getInputStream();
                    s=jsondata(inputStream);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return s;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            httpListener.jsondatas(s);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
    public String jsondata(InputStream inputStream) throws IOException {
        InputStreamReader reader=new InputStreamReader(inputStream);
        BufferedReader reader1=new BufferedReader(reader);
        String s=null;
        StringBuilder builder=new StringBuilder();
        while ((s=reader1.readLine())!=null){
            builder.append(s);
        }
        return builder.toString();
    }
    public interface HttpListener{
        void jsondatas(String s);
    }
    public void sethttplistener(HttpListener httpListener){
        this.httpListener=httpListener;
    }
}
