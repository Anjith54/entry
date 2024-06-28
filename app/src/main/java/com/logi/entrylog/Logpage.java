package com.logi.entrylog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Logpage extends AppCompatActivity {
    AppCompatButton b2,b1;
    EditText ed1,ed2,ed3,ed4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logpage);
        ed1=(EditText)findViewById(R.id.Uname);
        ed2=(EditText)findViewById(R.id.AdNo);
        ed3=(EditText)findViewById(R.id.SyNo);
        ed4=(EditText)findViewById(R.id.DptNo);
        b1=(AppCompatButton)findViewById(R.id.ADD) ;

        b2=(AppCompatButton)findViewById(R.id.Logout);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getName=ed1.getText().toString();
                String getAdmNo=ed2.getText().toString();
                String getSyNo=ed3.getText().toString();
                String getDptNo=ed4.getText().toString();
                Toast.makeText(getApplicationContext(),getName+getDptNo+getAdmNo+getSyNo,Toast.LENGTH_LONG).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }
}