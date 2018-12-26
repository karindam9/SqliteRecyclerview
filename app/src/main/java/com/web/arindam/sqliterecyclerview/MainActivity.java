package com.web.arindam.sqliterecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edt_name,edt_phone,edt_add;
    Button btn_submit,btn_fetch;

    ModelDemo modelDemo;
    Sqlitedata sqlitedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_name=findViewById(R.id.edt_name);
        edt_phone=findViewById(R.id.edt_phone);
        edt_add=findViewById(R.id.edt_add);
        btn_submit=findViewById(R.id.btn_submit);
        btn_fetch=findViewById(R.id.btn_fetch);

        modelDemo=new ModelDemo();
        sqlitedata=new Sqlitedata(this);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modelDemo.setName(edt_name.getText().toString());
                modelDemo.setPhn(edt_phone.getText().toString());
                modelDemo.setAdd(edt_add.getText().toString());
                sqlitedata.insert(modelDemo);
            }
        });
        btn_fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(in);
                finish();
            }
        });

    }
}
