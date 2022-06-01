package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText loginField, pswrdField, fioField;
    Button regButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();

        loginField = findViewById(R.id.regLoginField);
        pswrdField = findViewById(R.id.regPswrdField);
        fioField = findViewById(R.id.regFioField);
        regButton = findViewById(R.id.regButton);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (DB.isUserUnique(loginField.getText().toString(),view.getContext())){
                    User user = new User(loginField.getText().toString(), pswrdField.getText().toString());
                    user.setFio(fioField.getText().toString());
                    DB.addUser(user, view.getContext());
                    Toast.makeText(getApplicationContext(),"Юзер добавлен", Toast.LENGTH_SHORT).show();
                    DB.getAllUsers(view.getContext());
                }else {
                    Toast.makeText(getApplicationContext(),"Юзер уже существует", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}