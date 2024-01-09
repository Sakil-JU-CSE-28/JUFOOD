package com.example.jufood;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHandler extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView name;

    public MyViewHandler(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        name = itemView.findViewById(R.id.name);
    }
}
