package com.logi.entrylog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.jar.Attributes;

public class Logpage extends AppCompatActivity {
    AppCompatButton b2,b1;
    EditText ed1,ed2,ed3,ed4;
    String apiUrl="http://10.0.4.16:3000/api/students";



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
                JSONObject student=new JSONObject();
                try {
                    student.put("name",getName);
                    student.put("admission_number",getAdmNo);
                    student.put("system_number",getSyNo);
                    student.put("department",getDptNo);


                }
                catch (JSONException e){
                    throw new RuntimeException(e);
                };

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences =getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor editor= preferences.edit();
                editor.clear();
                editor.apply();
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }
}