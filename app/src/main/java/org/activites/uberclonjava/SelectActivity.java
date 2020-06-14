package org.activites.uberclonjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectActivity extends AppCompatActivity {

    Toolbar mToolBar;
    Button goToLogin;
    Button goToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        mToolBar = findViewById(R.id.toolBar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle("Seleccione una opción");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        goToLogin = findViewById(R.id.btnGoToLogin);
        goToRegister = findViewById(R.id.btnGoToRegister);


        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goLogin();
            }
        });

        goToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goRegister();
            }
        });

    }

    private void goRegister() {
        Intent intent = new Intent(SelectActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    private void goLogin() {
        Intent intent = new Intent(SelectActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}