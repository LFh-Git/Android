package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyListView extends AppCompatActivity {
    private List<Cat> cats = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        init();//数据初始化

        CatAdapter adapter = new CatAdapter(MyListView.this, R.layout.cat_item, cats);

//        ((ListView) findViewById(R.id.lists)).setAdapter(adapter);
        ListView listView = findViewById(R.id.lists);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cat cat = cats.get(position);
                Toast.makeText(MyListView.this, cat.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        cats.add(new Cat("低", R.mipmap.lsxg));
        cats.add(new Cat("调", R.mipmap.lsxg));
        cats.add(new Cat("小", R.mipmap.lsxg));
        cats.add(new Cat("怪", R.mipmap.lsxg));
        cats.add(new Cat("l", R.mipmap.lsxg));
        cats.add(new Cat("s", R.mipmap.lsxg));
        cats.add(new Cat("x", R.mipmap.lsxg));
        cats.add(new Cat("g", R.mipmap.lsxg));
        cats.add(new Cat("低", R.mipmap.lsxg));
        cats.add(new Cat("调", R.mipmap.lsxg));
        cats.add(new Cat("小", R.mipmap.lsxg));
        cats.add(new Cat("怪", R.mipmap.lsxg));
    }

}
