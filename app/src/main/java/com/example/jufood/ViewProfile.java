package com.example.jufood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ViewProfile extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private TextView usernameTextView;
    private TextView emailTextView;
    private TextView passwordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        dbHelper = new DatabaseHelper(this);
        usernameTextView = findViewById(R.id.textView1);
        emailTextView = findViewById(R.id.textView2);
        passwordTextView = findViewById(R.id.textView3);


        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");

        TextView tv = findViewById(R.id.tt1);
        tv.setText(username + " Profile's Information");


        // Query the database to retrieve user information
        Cursor cursor = dbHelper.getUserInfo(username);

        if (cursor.moveToFirst()) {
            // The cursor contains user information
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String password = cursor.getString(cursor.getColumnIndex("password"));

            // Update the UI with user information
            usernameTextView.setText("Username: " + username);
            emailTextView.setText("Email: " + email);
            passwordTextView.setText("Password: " + password);
        } else {
            // No user information found
            Toast.makeText(this, "User not found in the database", Toast.LENGTH_SHORT).show();
        }

        // Close the cursor when you are done with it
        cursor.close();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Find the specific menu item (e.g., "Home")
        MenuItem homeMenuItem = bottomNavigationView.getMenu().findItem(R.id.menu_home);

        homeMenuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(ViewProfile.this,Home.class);
                startActivity(intent);
                return true;
            }
        });

        MenuItem logout = bottomNavigationView.getMenu().findItem(R.id.menu_logout);

        logout.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent intent = new Intent(ViewProfile.this,WelcomeActivity.class);
                startActivity(intent);
                return true;
            }
        });

        MenuItem support = bottomNavigationView.getMenu().findItem(R.id.menu_support);
        support.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent intent = new Intent(ViewProfile.this, Support.class);
                startActivity(intent);
                return true;
            }
        });

        MenuItem profile = bottomNavigationView.getMenu().findItem(R.id.menu_profile);
        profile.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent intent = new Intent(ViewProfile.this,Profile.class);
                startActivity(intent);
                return true;
            }
        });

    }
}