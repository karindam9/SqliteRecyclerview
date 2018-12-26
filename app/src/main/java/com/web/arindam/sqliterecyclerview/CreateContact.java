package com.web.arindam.sqliterecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CreateContact extends AppCompatActivity {
    TextView tx_create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);
        tx_create=findViewById(R.id.tx_create);

        tx_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(CreateContact.this,Main3Activity.class);
                startActivity(in);

            }
        });
    }
}
