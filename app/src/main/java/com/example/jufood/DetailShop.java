package com.example.jufood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
public class DetailShop extends AppCompatActivity {
    private static final int REQUEST_CALL_PHONE_PERMISSION = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_shop);
        Intent intent = getIntent();
       TextView tv1 = findViewById(R.id.titleTextView);
        tv1.setText(intent.getStringExtra("name"));
        List<shopBot>items = new ArrayList<>();
        RecyclerView recView = findViewById(R.id.recycleview2);
        items.add(new shopBot("Rice",10,R.drawable.rice));
        items.add(new shopBot("Chicken",50,R.drawable.chicken));
        items.add(new shopBot("Dal",10,R.drawable.dal));
        items.add(new shopBot("Vorta(any)",10,R.drawable.vorta));
        items.add(new shopBot("Mutton",100,R.drawable.mutton));
        items.add(new shopBot("Rui",50,R.drawable.fish));
        items.add(new shopBot("Vegetable",20,R.drawable.veg));
        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.setAdapter(new ShopItemAdapter(getApplicationContext(),items));
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Find the specific menu item (e.g., "Home")
        MenuItem homeMenuItem = bottomNavigationView.getMenu().findItem(R.id.menu_home);

        homeMenuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
               Intent intent = new Intent(DetailShop.this,Home.class);
               startActivity(intent);
                return true;
            }
        });

        MenuItem logout = bottomNavigationView.getMenu().findItem(R.id.menu_logout);

        logout.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent intent = new Intent(DetailShop.this,WelcomeActivity.class);
                startActivity(intent);
                return true;
            }
        });

        MenuItem support = bottomNavigationView.getMenu().findItem(R.id.menu_support);
        support.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent intent = new Intent(DetailShop.this, Support.class);
                startActivity(intent);
                return true;
            }
        });

        MenuItem profile = bottomNavigationView.getMenu().findItem(R.id.menu_profile);
        profile.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent intent = new Intent(DetailShop.this,Profile.class);
                startActivity(intent);
                return true;
            }
        });

        SearchView searchView = findViewById(R.id.searchView);
        RecyclerView recyclerView = findViewById(R.id.recycleview2);
        ShopItemAdapter adapter = new ShopItemAdapter(getApplicationContext(), items);

// Set up the RecyclerView with your adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle search query submission (if needed)
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filter the items in your RecyclerView based on the search query
                List<shopBot> filteredItems = filterItems(newText, items);
                adapter.setItems(filteredItems);
                return true;
            }
        });

        Button order = findViewById(R.id.contactShopOwnerButton);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
    // Define a method to filter items based on the search query
    private List<shopBot> filterItems(String query, List<shopBot> items) {
        List<shopBot> filteredItems = new ArrayList<>();
        for (shopBot item : items) {
            // Perform your filtering logic here, e.g., check if item name contains the query
            if (item.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

}