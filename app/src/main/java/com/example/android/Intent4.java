package com.example.android;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Intent4 extends Activity {
    TextView show_para;
    String str;
    int isClear = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent4);
        show_para = findViewById(R.id.show_para);
        Button button_return4 = findViewById(R.id.button_return4);

        Bundle bundle = getIntent().getExtras();
        String userName= bundle.getString("userName");
        String email = bundle.getString("email");
        str = "userName: " + userName + "\n" + "email: " + email;
        show_para.setText(str);

        button_return4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("name","刘**");
                bundle.putString("age","2**");
                bundle.putString("专业","计算机科学与技术");
                intent.putExtras(bundle);
                intent.setClass(Intent4.this,MyIntent.class);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        final Button clear = findViewById(R.id.button_clear2);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isClear == 1){
                    show_para.setText(str);
                    isClear = 0;
                    clear.setText("清空参数");
                }
                else
                {
                    show_para.setText("");
                    isClear = 1;
                    clear.setText("显示参数");
                }
            }
        });
    }
}
