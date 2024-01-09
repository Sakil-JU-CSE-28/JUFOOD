package com.example.jufood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class DetailsView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_view);
        Intent intent = getIntent();
        TextView tv1 = findViewById(R.id.titleTextView);
        tv1.setText("Food corner of "+ intent.getStringExtra("name"));
        RecyclerView recView = findViewById(R.id.recView);
        List<item> items = new ArrayList<item>();
        items.add(new item("Dhansiri Hotel",R.drawable.s1));
        items.add(new item("Taj Mohol Hotel",R.drawable.s2));
        items.add(new item("Faruk Tea store",R.drawable.s3));
        items.add(new item("Junayed Hotel",R.drawable.s4));
        items.add(new item("Jack's Kitchen",R.drawable.s5));
        items.add(new item("Bangler Sad Hotel",R.drawable.s6));
        items.add(new item("Nurjahan Hotel",R.drawable.s7));
        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.setAdapter(new MyAdapter(getApplicationContext(),items));

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Find the specific menu item (e.g., "Home")
        MenuItem homeMenuItem = bottomNavigationView.getMenu().findItem(R.id.menu_home);

        homeMenuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(DetailsView.this,Home.class);
                startActivity(intent);
                return true;
            }
        });

        MenuItem logout = bottomNavigationView.getMenu().findItem(R.id.menu_logout);

        logout.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent intent = new Intent(DetailsView.this,WelcomeActivity.class);
                startActivity(intent);
                return true;
            }
        });

        MenuItem support = bottomNavigationView.getMenu().findItem(R.id.menu_support);
        support.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent intent = new Intent(DetailsView.this, Support.class);
                startActivity(intent);
                return true;
            }
        });

        MenuItem profile = bottomNavigationView.getMenu().findItem(R.id.menu_profile);
        profile.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent intent = new Intent(DetailsView.this,Profile.class);
                startActivity(intent);
                return true;
            }
        });
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle search query submission if needed
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filter the RecyclerView data based on the new text
                ((MyAdapter) recView.getAdapter()).filter(newText);
                return true;
            }
        });
    }
}