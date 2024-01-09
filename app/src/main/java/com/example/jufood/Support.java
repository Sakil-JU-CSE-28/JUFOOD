package com.example.jufood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Support extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        Button btn = findViewById(R.id.chatbotButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Support.this, SMS.class);
                startActivity(in);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Find the specific menu item (e.g., "Home")
        MenuItem homeMenuItem = bottomNavigationView.getMenu().findItem(R.id.menu_home);

        homeMenuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(Support.this,Home.class);
                startActivity(intent);
                return true;
            }
        });

        MenuItem logout = bottomNavigationView.getMenu().findItem(R.id.menu_logout);

        logout.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent intent = new Intent(Support.this,WelcomeActivity.class);
                startActivity(intent);
                return true;
            }
        });

        MenuItem support = bottomNavigationView.getMenu().findItem(R.id.menu_support);
        support.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent intent = new Intent(Support.this, Support.class);
                startActivity(intent);
                return true;
            }
        });

        MenuItem profile = bottomNavigationView.getMenu().findItem(R.id.menu_profile);
        profile.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent intent = new Intent(Support.this,Profile.class);
                startActivity(intent);
                return true;
            }
        });
    }
}