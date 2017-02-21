package com.example.user.sqlitelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button login, registrarse;
    private EditText etEmail, etPass;
    private DbHelper db;
    private Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new  DbHelper(this);
        session = new Session(this);
        login = (Button)findViewById(R.id.btnLogin);
        registrarse = (Button)findViewById(R.id.btnRegistrarse);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPass = (EditText)findViewById(R.id.etPass);
        login.setOnClickListener(this);
        registrarse.setOnClickListener(this);

        if (session.loggedin()){
            startActivity(new Intent(MainActivity.this, Principal.class));
        }
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnLogin:
                login();
                break;
            case R.id.btnRegistrarse:
                startActivity(new Intent(MainActivity.this,Registro.class));
                break;
            default:
        }

    }

    private void login(){
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();

        if(db.getUser(email,pass)){
            session.setLoggedin(true,email);

            startActivity(new Intent(MainActivity.this,Principal.class));
            finish();
        }else{
            Toast.makeText(getApplicationContext(), "Wrong email/password", Toast.LENGTH_SHORT).show();
        }
    }
}
