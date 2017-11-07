package com.example.android.canteen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Food extends AppCompatActivity {

    @Override
   public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
    }

    public void food1(View view)
    {
        Intent i = new Intent(this,FirstScreen.class);
        startActivity(i);

    }
    public void food2(View view)
    {
        Intent i = new Intent(this,FirstScreen.class);
        startActivity(i);

    }
}
