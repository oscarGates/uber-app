package org.activites.uberclonjava.includes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.activites.uberclonjava.R;

public class MyToolbar {
    public static void show(AppCompatActivity activity, String title, boolean buttonUp){
        Toolbar mToolBar = activity.findViewById(R.id.toolBar);
        activity.setSupportActionBar(mToolBar);
        activity.getSupportActionBar().setTitle(title);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(buttonUp);
    }
}
