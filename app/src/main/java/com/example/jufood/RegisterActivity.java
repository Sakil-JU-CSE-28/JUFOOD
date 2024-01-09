package com.example.jufood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText user,email,pass,confirm_pass;
    Button reg;
    DatabaseHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        user = (EditText) findViewById(R.id.editTextUsername);
        email = (EditText) findViewById(R.id.editTextEmail);
        pass = (EditText) findViewById(R.id.editTextPassword);
        confirm_pass = (EditText) findViewById(R.id.retypeTextPassword);
        reg = (Button) findViewById(R.id.buttonRegister);
        DB = new DatabaseHelper(this);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usr = user.getText().toString();
                String eml = email.getText().toString();
                String ps = pass.getText().toString();
                String cnfmps = confirm_pass.getText().toString();

                if(usr.equals("") || eml.equals("") || ps.equals("") || cnfmps.equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter all the fields",Toast.LENGTH_SHORT).show();
                }
                else{

                    if(ps.equals(cnfmps)){
                        Boolean checkuser = DB.checkusername(usr);
                        if(checkuser==false){
                            Boolean insert = DB.InsertData(usr, eml,ps,cnfmps);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),WelcomeActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(getApplicationContext(), "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }
}