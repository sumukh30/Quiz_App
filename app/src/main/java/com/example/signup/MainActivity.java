package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button signupbtn;
    String regu = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.usnm);
        password=findViewById(R.id.pwd);
        signupbtn=findViewById(R.id.signup);

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=username.getText().toString();
                String paswd=password.getText().toString();
                if(validatePassword(paswd)){

                    Bundle bundle=new Bundle();

                    bundle.putString("username",uname);
                    bundle.putString("password",paswd);

                    Intent intent=new Intent(MainActivity.this,Signin.class);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(MainActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
    public boolean validatePassword(String paswd){
        Pattern pattern=Pattern.compile(regu);
        Matcher matcher=pattern.matcher(paswd);

        return matcher.matches();
    }
}