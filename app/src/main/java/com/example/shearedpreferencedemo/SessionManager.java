package com.example.shearedpreferencedemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SessionManager
{
    Context context;
    SharedPreferences sp;

    SharedPreferences.Editor editor;

    //create sharedPreferance file name
    private final String PREF_FILE_NAME ="Shopping";
    //mode
    private final int PRIVATE_MODE= 0;

    private  final  String KEY_IF_LOGGED_IN = "key_session_if_logged_in";
    private  final  String KEY_NAME = "key_session_name";
    private  final  String KEY_EMAIL = "key_session_email";
    private  final  String KEY_PHONE= "key_session_phone";
    //constructor create
    public SessionManager(Context context)
    {
        //get the context bcz usi context ke through hum SharedPreferences get karvayenge
        this.context = context;
        //get the SharedPreferences
        sp=context.getSharedPreferences(PREF_FILE_NAME,PRIVATE_MODE);
        //calling Editor
        editor = sp.edit(); //edit mode me laye using --> PREF_FILE_NAME,PRIVATE_MODE
    }
//it will check the session if it is in boolean value the vo splash screen par chala jayega
    public boolean checkSession()
    {
        if(sp.contains(KEY_IF_LOGGED_IN))
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public  void createSession(String name,String email,String phone)
    {
        //session ke under value store karvani hai to hum use karenge Editor
        editor.putString(KEY_NAME , name);
        editor.putString(KEY_EMAIL , email);
        editor.putString(KEY_PHONE , phone);
        editor.putBoolean(KEY_IF_LOGGED_IN,true);
        editor.commit();//jub tak aap commit() nahi karenge tab tak SharedPreferance file create nhi hogi

    }

    //to get the data/session
    public  String getSessionDetails(String key)//hume key provide karni thi hume key ki value provide ho jayegi return statement me
    {
        String value = sp.getString(key,null);
        return value;

    }


    public void logoutSession()
    {
        //jaise hi humne Logout par click kiya to pura data delete kar dega or Login par aajayega
        editor.clear();
        editor.commit();
        //sari activity ko close karvake hum Login activity par chale jayenge
        Intent intent = new Intent(context, Login.class);
        context.startActivity(intent);
    }
}
