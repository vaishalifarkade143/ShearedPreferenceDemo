package com.example.shearedpreferencedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        //code to open splash screen for 2- 3 sec

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                SessionManager sessionManager = new SessionManager(getApplicationContext());

                boolean b = sessionManager.checkSession();
                if (b == true)
                {
                    //we use Intent to go from one Activity to another Activity
                    Intent intent = new Intent(getApplicationContext(), Profile.class);//splash screen se profile par lekar jayega
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(), Login.class);//splash screen se profile par lekar jayega
                    startActivity(intent);
                }

            }

        }, 2000);



    }
}

