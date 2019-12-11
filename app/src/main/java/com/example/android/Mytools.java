package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.io.PrintWriter;

public class Mytools extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_mytools);

        //调用phone
        Button button_call= findViewById(R.id.button_call);
        button_call.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri uri = Uri.parse("tel:18832285195");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });
        ///调用message
        Button button_message = findViewById(R.id.button_message);
        button_message.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:18832285195");
                Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
                intent.putExtra("lsxg","lsxg");
                startActivity(intent);
            }
        });
        ///相机
        Button button_camera = findViewById(R.id.button_camera);
        button_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);

                //这里没有实现图片的保存
            }
        });
        ///设置
        Button button_setting = findViewById(R.id.button_setting);
        button_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //直接进入设置界面， 通过 Setting.参数 可以进入不同的设置
                Intent intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                startActivityForResult(intent,0);
            }
        });
        ///浏览器
        Button button_browser = findViewById(R.id.button_browser);
        button_browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://gitee.com/lsxh");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        ///闹钟
        Button button_alarm = findViewById(R.id.button_alarm);
        button_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlarmClock.ACTION_DISMISS_ALARM);
                startActivity(intent);
            }
        });
        ///桌面
        Button button_desktop = findViewById(R.id.button_desktop);
        button_desktop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_MAIN);// 添加Action属性
                intent.addCategory(Intent.CATEGORY_HOME);// 添加Category属性
                startActivity(intent);// 启动Activity
            }
        });
    }
}

/*
* 常见的系统设置(android.provider.Settings)
*
* android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS	设置--可访问性
android.provider.Settings.ACTION_ADD_ACCOUNT	设置--账户和同步设置--添加账户
android.provider.Settings.ACTION_AIRPLANE_MODE_SETTINGS	设置--无线和网络设置--飞行模式
android.provider.Settings.ACTION_APN_SETTINGS	无线和网络设置--移动网络设置--接入点名称--APN
android.provider.Settings.ACTION_APPLICATION_SETTINGS	设置--应用程序
android.provider.Settings.ACTION_BLUETOOTH_SETTINGS	设置--无线和网络设置--蓝牙设置
android.provider.Settings.ACTION_DATE_SETTINGS	设置--日期和时间设置
android.provider.Settings.ACTION_DEVICE_INFO_SETTINGS	设置--关于手机
android.provider.Settings.ACTION_DISPLAY_SETTINGS	设置--显示


android.provider.Settings.ACTION_INPUT_METHOD_SETTINGS	设置--语言和键盘设置
android.provider.Settings.ACTION_INTERNAL_STORAGE_SETTINGS	设置--SD卡和手机内存--存储设置--手机内存
android.provider.Settings.ACTION_LOCALE_SETTINS	设置--语言和键盘设置--选择区域--语言
android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS	设置--位置和安全设置
android.provider.Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS	设置--应用程序--管理应用程序
android.provider.Settings.ACTION_MEMORY_CARD_SETTINGS	设置--SD卡和手机内存--存储设置--SD卡
android.provider.Settings.ACTION_PRIVACY_SETTINGS	设置--隐私设置
android.provider.Settings.ACTION_SEARCH_SETTINGS	设置--搜索设置
android.provider.Settings.ACTION_SECURITY_SETTINGS	设置--位置和安全设置
android.provider.Settings.ACTION_SETTINGS	设置
android.provider.Settings.ACTION_SOUND_SETTINGS	设置--声音设置
android.provider.Settings.ACTION_SYNC_SETTINGS	设置--账户与同步设置
android.provider.Settings.ACTION_USER_DICTIONARY_SETTINGS	设置--用户字典设置
android.provider.Settings.ACTION_WIFI_SETTINGS	设置--无线和网络设置--Wlan设置
android.provider.Settings.ACTION_WIRELESS_SETTINGS	设置--无线和网络设置--无线设置
android.provider.Settings.ACTION_WIFI_IP_SETTINGS	设置--无线和网络设置--Wlan设置--(菜单键)高级
android.provider.Settings.ACTION_QUICK_LAUNCH_SETTINGS	显示设置，以允许快速启动快捷键的配置
android.provider.Settings.ACTION_NETWORK_OPERATOR_SETTINGS	选择网络运营商的显示设置
android.provider.Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS	显示设置，以允许应用程序开发相关的设置配置
android.provider.Settings.ACTION_DATA_ROAMING_SETTINGS	选择of2G/3G显示设置
* */