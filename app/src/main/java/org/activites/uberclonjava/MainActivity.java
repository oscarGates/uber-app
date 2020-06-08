package org.activites.uberclonjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mIamDriver;
    Button mIamCustomer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIamDriver = findViewById(R.id.btnIAmDriver);
        mIamCustomer = findViewById(R.id.btnIAmCustomer);

        mIamCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSelectedAuth();
            }
        });
        mIamDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSelectedAuth();
            }
        });
    }

    private void goToSelectedAuth() {
        Intent intent = new Intent(MainActivity.this, SelectActivity.class);
        startActivity(intent);
    }
}
