package org.activites.uberclonjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
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

    }
}