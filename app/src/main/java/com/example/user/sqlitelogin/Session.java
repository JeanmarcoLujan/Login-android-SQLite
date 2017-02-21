package com.example.user.sqlitelogin;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by User on 20/02/2017.
 */
public class Session {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;

    public Session(Context ctx){
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences("myapp",Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public  void setLoggedin(boolean logggedin, String user){
        editor.putBoolean("loggedInmode",logggedin);
        editor.putString("email_pref",user);
        editor.commit();
    }

    public String getEmail(){
        return  prefs.getString("email_pref","");
    }

    public boolean loggedin(){
        //prefs.edit().remove("email_pref").commit();
        return prefs.getBoolean("loggedInmode",false);
        //return prefs.edit().remove("loggedInmode").commit();
    }

}
