package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signin extends AppCompatActivity {

    EditText username,password;
    Button signinbtn;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        username=findViewById(R.id.user);
        password=findViewById(R.id.pass);
        signinbtn=findViewById(R.id.signin);

        Bundle bundle=getIntent().getExtras();
        String uname=bundle.getString("username");
        String pwd=bundle.getString("password");

        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usm=username.getText().toString();
                String pas=password.getText().toString();

                if(usm.equals(uname)&&pas.equals(pwd)){
                    Toast.makeText(Signin.this, "Successful Login", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Signin.this,suces.class);
                    startActivity(intent);
                }
                else{
                    count++;
                    if(count>=3){
                        signinbtn.setEnabled(false);
                    }
                    Toast.makeText(Signin.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}