package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MyMenu extends AppCompatActivity {
    public TextView textV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_menu);
        textV = findViewById(R.id.my_menu);
        registerForContextMenu(textV);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v == textV) {
            menu.add(0, 1, 0, "上下文菜单");
            menu.add(0, 2, 0, "上下文菜单");
            menu.add(0, 3, 0, "上下文菜单");
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Toast.makeText(MyMenu.this, "菜单1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(MyMenu.this, "菜单2", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(MyMenu.this, "菜单3", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }
    //选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //四个参数的含义:

        // 1.group的id;2.item的id;3.是否排序;4.将要显示的内容
        menu.add(0, 1, 0, "新建");
        menu.add(0, 2, 0, "保存");
        SubMenu sub = menu.addSubMenu("更多");
        sub.add(0, 3, 0, "sublsxg");
        sub.add(0, 4, 0, "sublsxg");
        sub.add(0, 5, 0, "sublsxg");

        menu.add(1, 6, 0, "低调小怪");
        menu.add(1, 7, 1, "低调小怪");
        menu.add(1, 8, 5, "低调小怪");
        menu.add(1, 9, 2, "低调小怪");
        menu.add(1, 10, 3, "低调小怪");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                Toast.makeText(MyMenu.this,"新建菜单",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(MyMenu.this,"保存菜单",Toast.LENGTH_SHORT).show();
                break;
            case 3: case 4: case 5:
                Toast.makeText(MyMenu.this,"子菜单sublsxg",Toast.LENGTH_SHORT).show();
                break;
            case 6: case 7: case 8: case 9: case 10:
                Toast.makeText(MyMenu.this,"低调小怪",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }


}
