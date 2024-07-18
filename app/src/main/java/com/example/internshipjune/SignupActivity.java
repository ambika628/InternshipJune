package com.example.internshipjune;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignupActivity extends AppCompatActivity {

   EditText name,contact,email,password,confirmpassword;
    TextView alreadyAccount;
    Button submit;

    String emailPattern = "[a-zA-Z0-9._']+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        name=findViewById(R.id.signup_name);
        contact=findViewById(R.id.signup_contact);
        email=findViewById(R.id.signup_email);
        password=findViewById(R.id.signup_password);
        confirmpassword=findViewById(R.id.signup_confirm_password);
        submit=findViewById(R.id.signup_signup);
        alreadyAccount=findViewById(R.id.signup_already_account);


        alreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().trim().equals("")){
                    name.setError(("Please enter Valid Name"));
                } else if (contact.getText().toString().trim().equals("")) {
                    contact.setError("Enter a valid number ");
                }else if (contact.getText().toString().trim().length()<10){
                    contact.setError("10 number is required");
                }else if (email.getText().toString().trim().equals("")) {
                    email.setError("Email ID Required");
                } else if (!email.getText().toString().trim().matches(emailPattern)) {
                    email.setError("Enter a valid email Id");
            }else if (password.getText().toString().equals(" ")){
                    password.setError("Enter the valid password");
                } else if (password.getText().toString().length()<6){
                    password.setError("Min 6 Char password Required");
                } else if (confirmpassword.getText().toString().equals(" ")){
                        password.setError("Enter the valid cofirpassword");
                    } else if (!password.getText().toString().trim().matches(confirmpassword.getText().toString().trim())) {
                    confirmpassword.setError("Password Does Not  Match");
                } else {
                    Toast.makeText(SignupActivity.this, "Signup Successfully", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }
            }
        });

    }
}