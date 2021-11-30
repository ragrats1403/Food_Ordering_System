package com.example.foodorderingsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class RegistrationActivity extends AppCompatActivity {

    String tempuser = "";
    String temppw = "";
    String temprpw = "";
    String tempemail = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_form);
        TextInputEditText username = findViewById(R.id.username);
        TextInputEditText password = findViewById(R.id.password);
        TextInputEditText email = findViewById(R.id.email);
        TextInputEditText repeatpw = findViewById(R.id.passwordagain);



        Button signup;
        ImageView back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        signup = findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempuser = username.getText().toString();
                temppw=password.getText().toString();
                temprpw = repeatpw.getText().toString();
                tempemail = email.getText().toString();
                if(temppw.equals(temprpw)) {
                    DBContext dbContext = DBContext.getInstance(getApplicationContext());
                    Users user = new Users();
                    user.setUsername(tempuser);
                    user.setPw(temppw);
                    user.setEmail(tempemail);
                    dbContext.usersdao().insertuser(user);

                    Toast.makeText(RegistrationActivity.this,"Registration Successful!\nYou Can now Login",Toast.LENGTH_LONG).show();

                }
                else
                {

                    Toast errorToast = Toast.makeText(RegistrationActivity.this, "Passwords doesn't match!\nPlease Try Again",Toast.LENGTH_LONG);
                    errorToast.show();
                }
            }
        });


    }

}
