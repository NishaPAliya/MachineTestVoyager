package com.first.machinetestvoyager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText username = (EditText) findViewById(R.id.edt_username);
        EditText pwd = (EditText) findViewById(R.id.edt_password);
        Button btlogin = (Button) findViewById(R.id.btn_login);
        TextView btnnowregister = (TextView) findViewById(R.id.registernwbutton);


        preferences = getSharedPreferences("userdata",0);

        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            String usernamevalue = username.getText().toString();
            String userpwdvalue = pwd.getText().toString();

            String registeredusername = preferences.getString("username","");
            String registeredpassword = preferences.getString("userpassword","");


            if (usernamevalue.equals(registeredusername) && userpwdvalue.equals(registeredpassword))
            {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Invalid user!",Toast.LENGTH_LONG).show();
            }
            }
        });
        btnnowregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  =  new Intent(getApplicationContext(),Registration.class);
                startActivity(i);
            }
        });


    }
}