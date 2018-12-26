package com.web.arindam.sqliterecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.web.arindam.sqliterecyclerview.CreateContactUse.Modelrow;
import com.web.arindam.sqliterecyclerview.CreateContactUse.SqliteDemo;

public class Main3Activity extends AppCompatActivity {
    EditText et_name,et_phone;
    Button bt_save,bt_show;
//    SqliteDemo sqliteDemo;
//    Modelrow modelrow;
    SqliteDemo sqliteDemo;
    Modelrow modelrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        bt_save=findViewById(R.id.bt_save);
        bt_show=findViewById(R.id.bt_show);

        et_name=findViewById(R.id.et_name);
        et_phone=findViewById(R.id.et_phone);

//        sqliteDemo=new SqliteDemo(this);
//        modelrow=new Modelrow();
        modelrow=new Modelrow();
        sqliteDemo=new SqliteDemo(this);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valid()) {
//                modelrow.setName(et_name.getText().toString());
//                modelrow.setPhone(et_phone.getText().toString().trim());
//                sqliteDemo.insert(modelrow);
//                Intent in=new Intent(Main3Activity.this,Main4Activity.class);
//                startActivity(in);
                    modelrow.setName(et_name.getText().toString());
                    modelrow.setPhone(et_phone.getText().toString().trim());
                    sqliteDemo.insert(modelrow);
                    Intent in = new Intent(Main3Activity.this, Main4Activity.class);
                    startActivity(in);
                }

            }
        });
//        bt_show.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent in=new Intent(Main3Activity.this,Main4Activity.class);
//                startActivity(in);
//                finish();
//            }
//        });

    }

    private boolean valid() {
        boolean isvalid=true;
        if(et_name.getText().toString().isEmpty()){
            isvalid=false;
            Toast.makeText(this,"Enter name",Toast.LENGTH_LONG).show();
            et_name.requestFocus();
            return isvalid;
        }
        if(et_phone.getText().toString().isEmpty()){
            isvalid=false;
            Toast.makeText(this,"Enter phone",Toast.LENGTH_LONG).show();
            et_phone.requestFocus();
            return isvalid;
        }
        return isvalid;
    }
}
