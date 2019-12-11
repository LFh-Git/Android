package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //声明button
    Button button_wuziqi, button_calculate,button_cycle,button_intent,button_calendar;
    Button button_tools,button_dialog,button_menu,button_notification,button_list_view;
    Button button_share_parameter,button_sqlite,button_broadcast,button_server;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button关联xml
        button_wuziqi = findViewById(R.id.button_wuziqi);
        button_calculate = findViewById(R.id.button_calculate);
        button_cycle = findViewById(R.id.button_cycle);
        button_intent = findViewById(R.id.button_intent);
        button_calendar = findViewById(R.id.button_calendar);
        button_tools = findViewById(R.id.button_tools);
        button_dialog = findViewById(R.id.button_dialog);
        button_menu = findViewById(R.id.button_menu);
        button_notification = findViewById(R.id.button_notification);
        button_list_view = findViewById(R.id.button_list_view);
        button_share_parameter = findViewById(R.id.button_share_parameter);
        button_sqlite = findViewById(R.id.button_sqlite);
        button_broadcast = findViewById(R.id.button_broadcast);
        button_server = findViewById(R.id.button_server);

        //注册监听
        button_wuziqi.setOnClickListener(onClickListener);
        button_calculate.setOnClickListener(onClickListener);
        button_calendar.setOnClickListener(onClickListener);
        button_tools.setOnClickListener(onClickListener);
        button_intent.setOnClickListener(onClickListener);
        button_cycle.setOnClickListener(onClickListener);
        button_dialog.setOnClickListener(onClickListener);
        button_menu.setOnClickListener(onClickListener);
        button_notification.setOnClickListener(onClickListener);
        button_list_view.setOnClickListener(onClickListener);
        button_share_parameter.setOnClickListener(onClickListener);
        button_sqlite.setOnClickListener(onClickListener);
        button_broadcast.setOnClickListener(onClickListener);
        button_server.setOnClickListener(onClickListener);

    }
    private View.OnClickListener onClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            Button button = (Button)v;
            try {
                switch (button.getId()) {
                    case R.id.button_wuziqi:
                        Toast.makeText(getApplicationContext(),"五子棋",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,Wuziqi.class);
                        startActivity(intent);
                        break;
                    case R.id.button_calculate:
                        Toast.makeText(getApplicationContext(),"计算器",Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(MainActivity.this, Calculator.class);
                        startActivity(intent1);
                        break;
                    case R.id.button_calendar:
                        Toast.makeText(getApplicationContext(),"日历",Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(MainActivity.this,MyCalendar.class);
                        startActivity(intent2);
                        break;
                    case R.id.button_tools:
                        Toast.makeText(getApplicationContext(),"工具",Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(MainActivity.this,Mytools.class);
                        startActivity(intent3);
                        break;
                    case R.id.button_cycle:
                        Toast.makeText(getApplicationContext(),"Activity",Toast.LENGTH_SHORT).show();
                        Intent intent4 = new Intent(MainActivity.this,ActivityLife.class);
                        startActivity(intent4);
                        break;
                    case R.id.button_intent:
                        Toast.makeText(getApplicationContext(),"Intent",Toast.LENGTH_SHORT).show();
                        Intent intent5 = new Intent(MainActivity.this,MyIntent.class);
                        startActivity(intent5);
                        break;
                    case R.id.button_dialog:
                        Toast.makeText(getApplicationContext(),"Dialog",Toast.LENGTH_SHORT).show();
                        Intent intent6 = new Intent(MainActivity.this,MyDialog.class);
                        startActivity(intent6);
                        break;
                    case R.id.button_menu:
                        Toast.makeText(getApplicationContext(),"菜单",Toast.LENGTH_SHORT).show();
                        Intent intent7 = new Intent(MainActivity.this,MyMenu.class);
                        startActivity(intent7);
                        break;
                    case R.id.button_notification:
                        Toast.makeText(getApplicationContext(),"通知栏",Toast.LENGTH_SHORT).show();
                        Intent intent8 = new Intent(MainActivity.this,MyNotification.class);
                        startActivity(intent8);
                        break;
                    case R.id.button_list_view:
                        Toast.makeText(getApplicationContext(),"ListView",Toast.LENGTH_SHORT).show();
                        Intent intent9 = new Intent(MainActivity.this,MyListView.class);
                        startActivity(intent9);
                        break;
                    case R.id.button_share_parameter:
                        Toast.makeText(getApplicationContext(),"共享参数",Toast.LENGTH_SHORT).show();
                        Intent intent10 = new Intent(MainActivity.this,MySharedPreferences.class);
                        startActivity(intent10);
                        break;
                    case R.id.button_sqlite:
                    case R.id.button_broadcast:
                    case R.id.button_server:
                        Toast.makeText(getApplicationContext(),"后期学习完善",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }catch (Exception e) {
                Log.e("低调小怪","点击按钮监听事件出错");
            }
        }
    };

}
