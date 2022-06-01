package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    EditText loginField, pswrdField;
    Button enterButton, addUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide();

        loginField = findViewById(R.id.loginField);
        pswrdField = findViewById(R.id.pswrdField);
        enterButton = findViewById(R.id.enterButton);
        addUserButton = findViewById(R.id.addUserButton);

        //кнопка входа
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (DB.isUserExist(
                        loginField.getText().toString(),
                        pswrdField.getText().toString(),
                        view.getContext())){
                    startActivity(new Intent(SignInActivity.this, MainActivity.class));
                }else {
                    Toast.makeText(getApplicationContext(),"Пользователь не найден",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //кнопка добавления юзера
        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
            }
        });




    }
}