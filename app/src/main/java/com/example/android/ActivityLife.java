package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityLife extends AppCompatActivity {
    TextView showMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);

        showMessage = findViewById(R.id.text_activity);

        Button button_create = findViewById(R.id.button_create);
        button_create.setBackgroundColor(Color.TRANSPARENT);
        button_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage.setText("活动第一次创建时被调用");
            }
        });

        Button button_start = findViewById(R.id.button_start);
        button_start.setBackgroundColor(Color.TRANSPARENT);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage.setText("活动由不可见变为可见的时候调用");
            }
        });

        Button button_resume = findViewById(R.id.button_resume);
        button_resume.setBackgroundColor(Color.TRANSPARENT);
        button_resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage.setText("当活动准备开始与用户交互时会触发该方法，一般只会在需要执行以下的操作时才重写该事件");
            }
        });

        Button button_pause = findViewById(R.id.button_pause);
        button_pause.setBackgroundColor(Color.TRANSPARENT);
        button_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage.setText("系统准备去启动或者恢复另外一个活动的时候调用。或者当活动被切换到后台时将触发该方法:保存用户未提交的数据、关闭或清除引用的资源、注销广播");
            }
        });

        Button button_stop = findViewById(R.id.button_stop);
        button_stop.setBackgroundColor(Color.TRANSPARENT);
        button_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage.setText("当该活动完全不可见的时候被调用当一个新的活动打开，并覆盖该活动时,一个已存在的活动切换到前台时,活动被销毁时");
            }
        });

        Button button_destroy = findViewById(R.id.button_destroy);
        button_destroy.setBackgroundColor(Color.TRANSPARENT);
        button_destroy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage.setText("活动销毁之前被调用");
            }
        });

        Button button_restart = findViewById(R.id.button_restart);
        button_restart.setBackgroundColor(Color.TRANSPARENT);
        button_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage.setText("当活动由停止状态变为运行状态时被调用。即当用户通过Home按钮将该用户切换到后台，并在之后又打开该应用则会触发该事件。");
            }
        });

        Button button_clearActivity = findViewById(R.id.button_clearActivity);
        button_clearActivity.setBackgroundColor(Color.TRANSPARENT);
        button_clearActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage.setText("");
            }
        });
    }
}
