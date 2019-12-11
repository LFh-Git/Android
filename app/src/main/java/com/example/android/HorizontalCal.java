package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HorizontalCal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_cal);
        final TextView textView = findViewById(R.id.DisplayHorizontal);
        final TextView resultTextView = findViewById(R.id.ResultHorizontal);
//        final Calculate calculate = new Calculate();

        Button btn0 = findViewById(R.id.ScienceNum0);
        Button btn1 = findViewById(R.id.ScienceNum1);
        Button btn2 = findViewById(R.id.ScienceNum2);
        Button btn3 = findViewById(R.id.ScienceNum3);
        Button btn4 = findViewById(R.id.ScienceNum4);
        Button btn5 = findViewById(R.id.ScienceNum5);
        Button btn6 = findViewById(R.id.ScienceNum6);
        Button btn7 = findViewById(R.id.ScienceNum7);
        Button btn8 = findViewById(R.id.ScienceNum8);
        Button btn9 = findViewById(R.id.ScienceNum9);
        Button btnPoint = findViewById(R.id.SciencePoint);
//        Button btnAdd = findViewById(R.id.ScienceAdd);
//        Button btnRed = findViewById(R.id.ScienceReduce);
//        Button btnMul = findViewById(R.id.ScienceMultiplication);
//        Button btnDiv = findViewById(R.id.ScienceDivision);
//        Button btnClr = findViewById(R.id.ScienceClear);
//        Button btnEqu = findViewById(R.id.ScienceEqual);
        Button btnBack = findViewById(R.id.ScienceBackSpace);
        Button btnTransfer = findViewById(R.id.transferCalculate);
        Button btnSin = findViewById(R.id.Sin);
        Button btnCos = findViewById(R.id.Cos);
        Button btnTan = findViewById(R.id.Tan);
        Button btnE = findViewById(R.id.E);
        Button btnLn = findViewById(R.id.Ln);
        Button btnLog = findViewById(R.id.Log);
        Button btnSquare = findViewById(R.id.Square);
        Button btnCube = findViewById(R.id.Cube);
        Button btnY = findViewById(R.id.NSquare);
        Button btnReciprocal = findViewById(R.id.Reciprocal);
        Button btnRoot = findViewById(R.id.Root);
        Button btnPi = findViewById(R.id.Pai);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText()+"0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText()+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText()+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText()+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText()+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText()+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText()+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText()+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText()+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText()+"9");
            }
        });
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textView.setText(textView.getText()+"+");
//            }
//        });
//        btnRed.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textView.setText(textView.getText()+"-");
//            }
//        });
//        btnMul.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(textView.length()!=0){
//                    textView.setText(textView.getText()+"*");
//                }
//
//            }
//        });
//        btnDiv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(textView.length()!=0){
//                    textView.setText(textView.getText()+"/");
//                }
//            }
//        });
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText()+".");
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = textView.getText().toString();
                String tempReplace = temp.substring(0,temp.length()-1);
                textView.setText(tempReplace);

            }
        });
//        btnClr.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textView.setText("");
//                resultTextView.setText("");
//            }
//        });
//        btnEqu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String temp = textView.getText().toString();
//
//                Double result = calculate.stackCalculate(temp);
//                resultTextView.setText(result.toString());
//            }
//        });
        btnTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(HorizontalCal.this,Calculator.class);
                //startActivity(intent);
                HorizontalCal.this.finish();
            }
        });
        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//sin
                String temp = textView.getText().toString();
                Double result = Double.parseDouble(temp);
                result = Math.sin(result);
                resultTextView.setText("sin"+temp+" = "+result.toString());
            }
        });
        btnCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = textView.getText().toString();
                Double result = Double.parseDouble(temp);
                result = Math.cos(result);
                resultTextView.setText("cos"+temp+" = "+result.toString());
            }
        });
        btnTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = textView.getText().toString();
                Double result = Double.parseDouble(temp);
                result = Math.tan(result);
                resultTextView.setText("tan"+temp+" = "+result.toString());
            }
        });
        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double result = Math.E;
                resultTextView.setText("e = "+result.toString());
            }
        });
        btnLn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = textView.getText().toString();
                Double result = Double.parseDouble(temp);
                result = Math.log(result);
                resultTextView.setText("Ln"+temp+" = "+result.toString());
            }
        });
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = textView.getText().toString();
                Double result = Double.parseDouble(temp);
                result = Math.log10(result);
                resultTextView.setText("Log"+temp+" = "+result.toString());
            }
        });
        btnSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = textView.getText().toString();
                Double result = Double.parseDouble(temp);
                result = result*result;
                resultTextView.setText(result.toString());
            }
        });
        btnCube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = textView.getText().toString();
                Double result = Double.parseDouble(temp);
                result = result*result*result;
                resultTextView.setText(result.toString());
            }
        });
        btnReciprocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = textView.getText().toString();
                Double result = Double.parseDouble(temp);
                result = 1/result;
                resultTextView.setText(result.toString());
            }
        });
        btnRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = textView.getText().toString();
                Double result = Double.parseDouble(temp);
                result = Math.sqrt(result);
                resultTextView.setText(result.toString());
            }
        });
        btnPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double result = Math.PI;
                resultTextView.setText(result.toString());
            }
        });
        btnY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.length()!=0){
                    textView.setText(textView.getText()+"#");
                }
            }
        });
    }
}
