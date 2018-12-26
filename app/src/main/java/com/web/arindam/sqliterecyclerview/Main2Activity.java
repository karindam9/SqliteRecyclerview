package com.web.arindam.sqliterecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
//    ListView recyclerview;
    RecyclerView recyclerview;
    ArrayList<ModelDemo>arrayList=new ArrayList<>();
//    Customadapter adapter;
    RecyclerAdapter adapter;

    Sqlitedata sqlitedata;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerview=findViewById(R.id.recyclerview);

        sqlitedata=new Sqlitedata(this);

        arrayList=sqlitedata.getAllUser();
        adapter=new RecyclerAdapter(arrayList,this);
        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());


//        adapter=new RecyclerAdapter(arrayList,this);
        recyclerview.setAdapter(adapter);
    }
}
