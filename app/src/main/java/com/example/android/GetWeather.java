package com.example.android;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// 获取网络天气信息
public class GetWeather extends AppCompatActivity {
    String weather;
    String parsedJson = "获取天气失败";
    public void sendRequest(){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    //获取到HttpConnection的实例，new出一个URL对象，并传入目标的网址，然后调用一下openConnection（）方法
                    URL url = new URL("http://www.weather.com.cn/data/sk/101090201.html");
                    // manifest文件增加：android:usesCleartextTraffic="true"
                    // 解决高版本只能https，不能http问题（Cleartext HTTP traffic to XXX not permitted）
                    Log.e("wyg2",url.toString());
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET"); //得到了HttpConnection的实例后，设置请求所用的方法（GET：从服务器获取数据，POST：提交数据给服务器）
                    connection.setConnectTimeout(8000);//设置连接超时，读取的毫秒数
                    connection.setReadTimeout(8000);

                    InputStream in = connection.getInputStream();//利用getInputStream（）方法获取服务器的返回的输入流，然后读取
                    reader = new BufferedReader(new InputStreamReader(in));// 对获取到的输入流进行读取

                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    weather = response.toString();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        //调用disconnect（）方法将HTTP连接关闭掉
                        connection.disconnect();
                    }
                }
            }
//        }).start();
//    }
    public void parseRequest() {
        try {
            JSONObject object = new JSONObject(weather);
            JSONObject object1 = object.getJSONObject("weatherinfo");
            String city = object1.getString("city");
            String temp = object1.getString("temp");
            String WD = object1.getString("WD");
            String WS = object1.getString("WS");
            String SD = object1.getString("SD");
            String AP = object1.getString("AP");
            parsedJson =  city + ":" + temp + ":" + WD +WS+ ":" +SD+ ":" +AP;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getWeather()
    {
        String str = this.parsedJson;
        return str;
    }
}
