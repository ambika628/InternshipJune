package com.example.internshipjune;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
   Button signin;
   EditText email, password;
   TextView forgotPassword, createAccount;

   String emailPattern = "[a-zA-Z0-9._']+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signin = findViewById(R.id.main_signin);
        email = findViewById(R.id.main_email);
        password = findViewById(R.id.main_password);
        forgotPassword=findViewById(R.id.main_forgot_password);
        createAccount=findViewById(R.id.main_create_account);

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,forgotPasswordActivity.class);
                startActivity(intent);
            }
        });
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().trim().equals("")){
                    email.setError("Email Id Required ");
                }
                else if(!email.getText().toString().trim().matches(emailPattern)){
                    email.setError("Please enter a valid email address");
                }
                else if(password.getText().toString().trim().equals("")){
                    password.setError("Password Id Required ");
                } else if (password.getText().toString().trim().length()<6) {
                    password.setError("Minimum 6 char Required");
                } else{
                System.out.println("Login Successfully");
                Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,DashboardActivity.class);
                startActivity(intent);
                }}
        });


    }
}