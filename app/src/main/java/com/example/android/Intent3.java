package com.example.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Intent3 extends Activity {
    TextView show_par;
    String str;
    int isClear = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent3);
        show_par = findViewById(R.id.show_par);

        Bundle bundle = getIntent().getExtras();
        String userName= bundle.getString("userName");
        String passwd = bundle.getString("passwd");
        str = "userName: " + userName + "\n" + "password: " + passwd;
        show_par.setText(str);

        Button button = findViewById(R.id.button_return3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent3.this.finish();
            }
        });

        final Button clear = findViewById(R.id.button_clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isClear == 1){
                    show_par.setText(str);
                    isClear = 0;
                    clear.setText("清空");
                }
                else
                {
                    show_par.setText("");
                    isClear = 1;
                    clear.setText("显示");
                }
            }
        });

    }
}
