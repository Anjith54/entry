package com.logi.entrylog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    AppCompatButton b1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText) findViewById(R.id.Uname);
        ed2=(EditText) findViewById(R.id.Pass);
        b1=(AppCompatButton) findViewById(R.id.Log);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getUsername=ed1.getText().toString();
                String getPassword=ed2.getText().toString();
                if (getUsername.equals("admin")&& getPassword.equals("12345"))
                {
                    Intent i=new Intent(getApplicationContext(), Logpage.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(),"wrong username or password",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}