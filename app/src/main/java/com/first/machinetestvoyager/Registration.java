package com.first.machinetestvoyager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    String name,email,registerpassword , cnfmpassword;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        EditText etname = (EditText) findViewById(R.id.edt_name);
        EditText etemail = (EditText) findViewById(R.id.edt_email);
        EditText etpassword = (EditText) findViewById(R.id.edtreg_password);
        EditText etcpasword = (EditText) findViewById(R.id.edtreg_cfm_password);
        Button btregister = (Button) findViewById(R.id.btn_register);
        TextView txloginnow = (TextView) findViewById(R.id.loginnwbutton);

        preferences = getSharedPreferences("userdata",0);

        btregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = etname.getText().toString().trim();
                email = etemail.getText().toString().trim();
                registerpassword = etpassword.getText().toString().trim();
                cnfmpassword = etcpasword.getText().toString().trim();

                if (name.length()<1)
                {
                    Toast.makeText(getApplicationContext(), "Please Enter Username ", Toast.LENGTH_LONG).show();
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    Toast.makeText(getApplicationContext(), "Please Enter Valid Email", Toast.LENGTH_LONG).show();
                }
                else if (registerpassword.length()<6)
                {
                    if (!registerpassword.equals(cnfmpassword))
                    {
                        Toast.makeText(getApplicationContext(), "Password fields are not same and atleast 6 digit", Toast.LENGTH_LONG).show();
                    }

                }
                else {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username", name);
                    editor.putString("useremail", email);
                    editor.putString("userpassword", registerpassword);
                    editor.apply();
                    Toast.makeText(getApplicationContext(), "user registered! ", Toast.LENGTH_LONG).show();
                }

            }
        });
        txloginnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });


    }
}