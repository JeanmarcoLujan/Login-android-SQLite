package com.example.user.sqlitelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity implements View.OnClickListener {
    private Button btnRegistro, btnReturn;
    private EditText newEmail, newPass;
    private DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        db = new DbHelper(this);

        btnRegistro = (Button)findViewById(R.id.btnRegistro);
        btnReturn = (Button)findViewById(R.id.btnReturnLogin);
        newEmail = (EditText)findViewById(R.id.etEmailNew);
        newPass = (EditText)findViewById(R.id.etPassNew);

        btnRegistro.setOnClickListener(this);
        btnReturn.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnRegistro:
                register();
                break;
            case R.id.btnReturnLogin:
                startActivity(new Intent(Registro.this,MainActivity.class));
                finish();
                break;
            default:

        }
    }

    private void register(){
        String email = newEmail.getText().toString();
        String pass = newPass.getText().toString();
        if (email.isEmpty() && pass.isEmpty()){
            displayToast("Email/password field empty");
        }else{
            db.addUser(email,pass);
            displayToast("User registered");
            finish();
        }
    }

    private void displayToast(String mensaje){
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
    }

}
