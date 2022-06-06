package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DB.allExpence(this);
    }

    public void addExpenceActivity(View view) {

        startActivity(new Intent(MainActivity.this, AddExpenceActivity.class));
    }
}