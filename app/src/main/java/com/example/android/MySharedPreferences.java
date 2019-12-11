package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MySharedPreferences extends AppCompatActivity {
    private Button saveData ,getSaveData ,clearData;
    private EditText userName,password;
    TextView sharedata;

    public <T extends View> T $(int id) {
        return (T) findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shared_preferences);

        saveData = $(R.id.ok);
        getSaveData = $(R.id.display);
        clearData = $(R.id.clear);
        userName = $(R.id.name);
        password = $(R.id.passwd);

        sharedata = findViewById(R.id.sharedata);

        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //创建名为“data”的文件，加入键值对，保存数据
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name",userName.getText().toString());
                editor.putString("password",password.getText().toString());
                //必须commit
                editor.commit();
            }
        });
        getSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //取出文件中键值对，并提示出来
                SharedPreferences preferences = getSharedPreferences("data",MODE_PRIVATE);
                String name = preferences.getString("name","");
                String password = preferences.getString("password","");
                sharedata.setText("共享参数内容\n" + "用户名：" + name+ "\n" + "密码：" + password);
            }
        });

        clearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //清空数据
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.clear();
                editor.commit();
            }
        });

    }
}
