package com.example.shearedpreferencedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Profile extends AppCompatActivity
{
    SessionManager sessionManager;
    TextView profile_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sessionManager = new SessionManager(getApplicationContext());
        profile_name = (TextView) findViewById(R.id.profile_name);

         //session get kiya hai  .name vala of use welcome ke baju me set karvayenge
        String name = sessionManager.getSessionDetails("key_session_name");
        profile_name.setText(name); //set the name

        //for getting the email id key
//        String email = sessionManager.getSessionDetails("key_session_email");
//        profile_name.setText(email);
    }
    public void logout(View view)
    {
        sessionManager.logoutSession();
    }
}