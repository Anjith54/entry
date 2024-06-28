package com.logi.entrylog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
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
        SharedPreferences preferences =getSharedPreferences("login",MODE_PRIVATE);
        String username=preferences.getString("user",null);
        if(username!=null)
        {
            Intent i=new Intent(getApplicationContext(), Logpage.class);
            startActivity(i);
        }


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
                    SharedPreferences preferences =getSharedPreferences("login",MODE_PRIVATE);
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("user","admin");
                    editor.apply();
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