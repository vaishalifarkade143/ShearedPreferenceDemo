package com.example.shearedpreferencedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity
{
    SessionManager sessionManager;
    EditText reg_name1,reg_emai1,reg_pass1,reg_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        sessionManager = new SessionManager(getApplicationContext());

        reg_name1 = (EditText) findViewById(R.id.reg_name1);
        reg_emai1 = (EditText) findViewById(R.id.reg_emai1);
        reg_pass1 = (EditText) findViewById(R.id.reg_pass1);
        reg_phone = (EditText) findViewById(R.id.reg_phone);

    }

    public void registerHere(View view)
    {
        String name1 = reg_name1.getText().toString();
        String email1 = reg_emai1.getText().toString();
        String pass1 = reg_pass1.getText().toString();
        String phone1 = reg_phone.getText().toString();


        //insert into mysql database

        sessionManager.createSession(name1,email1,phone1);//jo jo data store karna hai vo

        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
    public void openLoginScreen(View view)
    {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
    }
}