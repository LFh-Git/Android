package com.example.android;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyNotification extends AppCompatActivity {
    private Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notification);

        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                //创建通知渠道实例
                //并为它设置属性
                //通知渠道的ID,随便写
                String id = "channel_01";
                //用户可以看到的通知渠道的名字，R.string.app_name就是strings.xml文件的参数，自定义一个就好了
                CharSequence name = getString(R.string.app_name);
                //用户可看到的通知描述
                String description = getString(R.string.app_name);
                //构建NotificationChannel实例
                NotificationChannel notificationChannel =
                        new NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH);
                //配置通知渠道的属性
                notificationChannel.setDescription(description);
                //设置通知出现时的闪光灯
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(Color.RED);
                //设置通知出现时的震动
                notificationChannel.enableVibration(true);
                notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 100});
                //在notificationManager中创建通知渠道
                manager.createNotificationChannel(notificationChannel);

                //蓝色字是个新方法，旧的被api放弃了
                Notification notification = new NotificationCompat.Builder(MyNotification.this, id)
                        .setContentTitle("标题")
                        .setContentText("内容666666666666666666666666666")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.lsxg)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.lsxg))
                        .build();
                manager.notify(1, notification);


            }
        });

    }
}
