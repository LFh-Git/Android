package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//学习使用intent 跳转 参数设置
public class MyIntent extends AppCompatActivity {
    private TextView text_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_intent);

        text_show = findViewById(R.id.show_parameter);

        Button button_1 = findViewById(R.id.button_intent1);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyIntent.this,Intent1.class);
                startActivity(intent);
            }
        });

        Button button_2 = findViewById(R.id.button_intent2);
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //需在manifests中注册    隐式出错 未解决
//                Intent intent = new Intent("android.intent.action.IntentTwo");
//                intent.addCategory("android.intent.category.CateIntentTow");
                Intent intent = new Intent(MyIntent.this,Intent2.class);
                startActivity(intent);
            }
        });

        Button button_3 = findViewById(R.id.button_intent3);
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("userName","低调小怪");
                bundle.putString("passwd","lsxg");
                intent.putExtras(bundle);

                intent.setClass(MyIntent.this,Intent3.class);
                startActivity(intent);
                //putExtra()  一个参数
            }
        });

        Button button_4 = findViewById(R.id.button_intent4);
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("userName","低调小怪");
                bundle.putString("email","lsxgls@qq.com");
                intent.putExtras(bundle);
                intent.setClass(MyIntent.this,Intent4.class);
                startActivityForResult(intent,0);
            }
        });
    }

    //返回数据处理
    protected  void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode)
        {
            case 0:
                if(resultCode == RESULT_OK)
                {
                    Bundle bundle = data.getExtras();
                    String name = bundle.getString("name");
                    String age = bundle.getString("age");
                    String zy = bundle.getString("专业");
                    String str = "name: " + name + "\n" + "age: " + age + "\n" + "专业:" + zy;
                    text_show.setText(str);
                }
                break;
            default:
                break;
        }
    }
}
