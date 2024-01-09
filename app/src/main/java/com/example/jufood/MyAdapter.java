package com.example.jufood;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHandler> {
    Context context;
    List<item> items;
    List<item> originalItems;


    @NonNull
    @Override
    public MyViewHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.row_ad, parent, false);
        return new MyViewHandler(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHandler holder, int position) {


        // Set the calculated height to the ImageView
        CardView cardView = holder.itemView.findViewById(R.id.cardView);
        ImageView imageView = holder.itemView.findViewById(R.id.imageView);
        TextView nameTextView = holder.itemView.findViewById(R.id.nameTextView);
        item i = items.get(position);
        imageView.setImageResource(i.getImage());
        nameTextView.setText(i.getName());

       cardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              Toast.makeText(view.getContext(),"Welcome to " + i.name,Toast.LENGTH_SHORT).show();
              if(i.name.equals("Bottola")){
                  Intent intent = new Intent(view.getContext(),DetailsView.class);
                  intent.putExtra("name",i.name);
                  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                  view.getContext().startActivity(intent);
              }
              else if(i.name.equals("Dhansiri Hotel")){
                  Intent intent = new Intent(view.getContext(),DetailShop.class);
                  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                  intent.putExtra("name",i.name);
                  view.getContext().startActivity(intent);
              }
              else if(i.name.equals("Taj Mohol Hotel")){
                  Intent intent = new Intent(view.getContext(),DetailShop.class);
                  intent.putExtra("name",i.name);
                  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                  view.getContext().startActivity(intent);
              }
              else if(i.name.equals("Faruk Tea store")){
                  Intent intent = new Intent(view.getContext(),DetailShop.class);
                  intent.putExtra("name",i.name);
                  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                  view.getContext().startActivity(intent);
              }
              else if(i.name.equals("Junayed Hotel")){
                  Intent intent = new Intent(view.getContext(),DetailShop.class);
                  intent.putExtra("name",i.name);
                  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                  view.getContext().startActivity(intent);
              }
              else if(i.name.equals("Jack's Kitchen")){
                  Intent intent = new Intent(view.getContext(),DetailShop.class);
                  intent.putExtra("name",i.name);
                  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                  view.getContext().startActivity(intent);
              }
              else if(i.name.equals("Bangler Sad Hotel")){
                  Intent intent = new Intent(view.getContext(),DetailShop.class);
                  intent.putExtra("name",i.name);
                  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                  view.getContext().startActivity(intent);
              }
              else if(i.name.equals("Nurjahan Hotel")){
                  Intent intent = new Intent(view.getContext(),DetailShop.class);
                  intent.putExtra("name",i.name);
                  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                  view.getContext().startActivity(intent);
              }
              else  if(i.name.equals("SalamBorkot")){
                  Intent intent = new Intent(view.getContext(),DetailsView.class);
                  intent.putExtra("name",i.name);
                  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                  view.getContext().startActivity(intent);
              }
              else  if(i.name.equals("Robindronath Hall")){
                  Intent intent = new Intent(view.getContext(),DetailsView.class);
                  intent.putExtra("name",i.name);
                  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                  view.getContext().startActivity(intent);
              }
              else  if(i.name.equals("Tarjan Point")){
                  Intent intent = new Intent(view.getContext(),DetailsView.class);
                  intent.putExtra("name",i.name);
                  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                  view.getContext().startActivity(intent);
              }
              else  if(i.name.equals("Prantik")){
                  Intent intent = new Intent(view.getContext(),DetailsView.class);
                  intent.putExtra("name",i.name);
                  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                  view.getContext().startActivity(intent);
              }
              else  if(i.name.equals("Bismail")){
                  Intent intent = new Intent(view.getContext(),DetailsView.class);
                  intent.putExtra("name",i.name);
                  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                  view.getContext().startActivity(intent);
              }
              else  if(i.name.equals("Dairy")){
                  Intent intent = new Intent(view.getContext(),DetailsView.class);
                  intent.putExtra("name",i.name);
                  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                  view.getContext().startActivity(intent);
              }
           }
       });
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    public MyAdapter(Context context, List<item> items) {
        this.context = context;
        this.items = items;
        this.originalItems = new ArrayList<>(items); // Make a copy of the original data
    }
    public void filter(String query) {
        items.clear(); // Clear the current data

        // If the query is empty, restore the original data
        if (query.isEmpty()) {
            items.addAll(originalItems); // Restore original data
        } else {
            // Filter the data based on the query
            query = query.toLowerCase();
            for (item item : originalItems) {
                if (item.getName().toLowerCase().contains(query)) {
                    items.add(item);
                }
            }
        }

        notifyDataSetChanged(); // Notify adapter of data change
    }

}
