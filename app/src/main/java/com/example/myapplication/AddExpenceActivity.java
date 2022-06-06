package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddExpenceActivity extends AppCompatActivity {

    EditText valueField, dateField, textField;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expence);
        getSupportActionBar().hide();

        valueField = findViewById(R.id.addExpenceValueField);
        dateField = findViewById(R.id.addExpenceDateField);
        textField = findViewById(R.id.addExpenceTextField);
        addButton = findViewById(R.id.addExpenceButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Expence expence = new Expence(User.USER_ID, Double.parseDouble(valueField.getText().toString()), dateField.getText().toString(), textField.getText().toString());

                DB.addExpence(expence, v.getContext());
            }
        });
    }
}