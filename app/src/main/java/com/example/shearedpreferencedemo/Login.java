package com.example.shearedpreferencedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity
{
    SessionManager sessionManager;
    EditText log_emai1,log_pass1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         sessionManager = new SessionManager(getApplicationContext());
        log_emai1 = (EditText) findViewById(R.id.log_emai1);
        log_pass1 = (EditText) findViewById(R.id.log_pass1);
    }

    //login code
    public void loginHere(View view)
    {
        String email = log_emai1.getText().toString();
        String pass = log_pass1.getText().toString();

        //checking the email n pass which is store in SP is matching or not which is store in sessionManager which was enter while registration n
          // SP == session
        if(email.equals("v@gmail.com")  && pass.equals("123"))
           {
               //agar email or pass match hota hai to vo session create karega
               sessionManager.createSession("prachi","p@gmail.com","123445566");
               Intent intent = new Intent(this, Profile.class);
               startActivity(intent);
           }
        else
        {
            Toast.makeText(this, "Email n Password didn't match", Toast.LENGTH_SHORT).show();
        }
    }


    public  void openRegisterscreen(View view)
    {
        Intent intent = new Intent(getApplicationContext(),Register.class);//getApplicationContext() is equal to "this" keyword
        startActivity(intent);

    }
}