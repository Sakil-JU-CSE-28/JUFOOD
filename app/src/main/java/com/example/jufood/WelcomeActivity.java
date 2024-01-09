package com.example.jufood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome2);
        Intent in = new Intent(getApplicationContext(),RegisterActivity.class);
        Intent in1 = new Intent(getApplicationContext(),LoginActivity.class);
        Button reg = findViewById(R.id.registerButton);
        Button login = findViewById(R.id.signInButton);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(in);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(in1);
            }
        });
    }
}