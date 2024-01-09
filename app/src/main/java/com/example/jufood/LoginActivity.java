package com.example.jufood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Profile profile;
    Button login;
    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);
        login = findViewById(R.id.buttonLogin);
        DB = new DatabaseHelper(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(DB.checkusernamePass(user,pass)){
                    Toast.makeText(getApplicationContext(), "Successfully login!!", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    String us = username.getText().toString();
                    String pas = password.getText().toString();
                    editor.putString("username", us);
                    editor.apply();
                    Intent intent = new Intent(getApplicationContext(),Home.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "username or password error!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}