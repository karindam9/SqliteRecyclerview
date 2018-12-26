package com.web.arindam.sqliterecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.web.arindam.sqliterecyclerview.CreateContactUse.Modelrow;
import com.web.arindam.sqliterecyclerview.CreateContactUse.RecylerAdapter1;
import com.web.arindam.sqliterecyclerview.CreateContactUse.SqliteDemo;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {
    RecyclerView recyler;
    ArrayList<Modelrow>arrayList=new ArrayList<>();
    RecylerAdapter1 adapter1;
//    SqliteDemo sqliteDemo;
    SqliteDemo sqliteDemo;

    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        recyler=findViewById(R.id.recyler);

//        sqliteDemo=new SqliteDemo(this);
//        arrayList=sqliteDemo.getAlUser();
        sqliteDemo=new SqliteDemo(this);
        arrayList=sqliteDemo.getAlUser();

        adapter1=new RecylerAdapter1(arrayList,this);

        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyler.setLayoutManager(layoutManager);
        recyler.setItemAnimator(new DefaultItemAnimator());
        recyler.setAdapter(adapter1);


    }
}
