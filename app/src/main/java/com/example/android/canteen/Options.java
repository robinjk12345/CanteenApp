package com.example.android.canteen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.VectorEnabledTintResources;
import android.view.View;

public class Options extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }

    public void next2(View view)
    {
        Intent i = new Intent(this,Food.class);
        startActivity(i);

    }
    public void next3(View view)
    {
        Intent i = new Intent(this,XeroxMain.class);
        startActivity(i);

    }
    public void next4(View view)
    {
        Intent i = new Intent(this,Stationary1.class);
        startActivity(i);

    }



}
