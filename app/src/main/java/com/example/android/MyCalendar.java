package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyCalendar extends AppCompatActivity {
    int year,month,day;
    int ny,nm,nd;
    DatePicker datePicker;
    String sedate;
    String strDate1;
    private TextView select_date,others;
    GetWeather weather = new GetWeather();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        select_date = findViewById(R.id.select_date);
        others = findViewById(R.id.others);
        datePicker = findViewById(R.id.datePicker);
        Calendar calendar = Calendar.getInstance();

        ny = calendar.get(Calendar.YEAR);
        nm = calendar.get(Calendar.MONTH);
        nd = calendar.get(Calendar.DAY_OF_MONTH);
        strDate1 = year + "-" + (nm+1) + "-" + nd;

        try {
            show(ny,nm,nd);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        year = ny;month = nm;day = nd;
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                MyCalendar.this.year = year;
                MyCalendar.this.month = monthOfYear;
                MyCalendar.this.day = dayOfMonth;
                try {
                    show(year,monthOfYear,dayOfMonth);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    private void show(int year,int month,int day) throws ParseException {
        if(year == MyCalendar.this.ny && month == MyCalendar.this.nm && day == MyCalendar.this.nd)
            MyCalendar.this.sedate = "当前日期:" + year + "年" + (month+1) + "月" + day + "日";
        else
            MyCalendar.this.sedate = "选中日期:" + year + "年" + (month+1) + "月" + day + "日";
        select_date.setText(sedate);
        String strDate2 = year + "-" + (month+1) + "-" + day;
        int days = getDays(strDate2,MyCalendar.this.strDate1);

        if(days>737426)
            others.setText((days-737426)+" 天后");
        else if(days<737426)
            others.setText((737426-days)+" 天前");
        else
        {
//            others.setText("天气或农历或随手记事或添加日程还不会");
            weather.sendRequest();
            weather.parseRequest();
            String str = weather.getWeather();
            others.setText(str);

        }

    }
    public int getDays(String strDate1,String strDdate2) throws ParseException {
        //"yyyy-mm-dd"  格式
        //算两个日期间隔多少天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format.parse(strDate1);
        Date date2 = format.parse(strDdate2);

        int res = (int) ((date1.getTime() - date2.getTime()) / (1000*3600*24));
        return res;
    }

}
