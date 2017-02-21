package com.example.user.sqlitelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    private Button btnLogout;
    private TextView tvEmail;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        session = new Session(this);
        if (!session.loggedin()){
            logout();
        }
        tvEmail = (TextView)findViewById(R.id.tvEmail);
        tvEmail.setText(session.getEmail());
        btnLogout = (Button)findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    private void logout(){
        session.setLoggedin(false,"");
        finish();
        startActivity(new Intent(Principal.this, MainActivity.class));
    }
}
