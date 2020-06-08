package org.activites.uberclonjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class SelectActivity extends AppCompatActivity {

    Toolbar mToolBar;

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