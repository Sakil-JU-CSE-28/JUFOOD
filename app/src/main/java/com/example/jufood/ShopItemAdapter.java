package com.example.jufood;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ShopItemAdapter extends RecyclerView.Adapter<MyViewHandler>{
    List<shopBot> items;
    Context context;
    @NonNull
    @Override
    public MyViewHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHandler(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHandler holder, int position) {
        String name = items.get(position).getName();
        int price = items.get(position).getPrice();

// Create a formatted string with different styles for name and price
        SpannableString formattedText = new SpannableString(name + "\n" + price + " taka");

// Apply different text styles and sizes to different parts of the text
        formattedText.setSpan(new StyleSpan(Typeface.BOLD), 0, name.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        formattedText.setSpan(new AbsoluteSizeSpan(18, true), 0, name.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

// Set a different text color for the price part
        int priceStart = name.length() + 1; // Add 1 to account for the newline character
        int priceEnd = priceStart + String.valueOf(price).length();
        formattedText.setSpan(new ForegroundColorSpan(Color.MAGENTA), priceStart, priceEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

// Set the formatted text to the TextView
        holder.name.setText(formattedText);


        int aspectRatioWidth = 16;
        int aspectRatioHeight = 9;

        // Calculate the height for the ImageView
        int imageViewHeight = (int) (holder.itemView.getContext().getResources().getDisplayMetrics().widthPixels *
                ((float) aspectRatioHeight / aspectRatioWidth));

        // Set the calculated height to the ImageView
        holder.imageView.getLayoutParams().height = imageViewHeight;

        holder.imageView.setImageResource(items.get(position).getImage());
    }

    private List<shopBot> originalItems; // Add this private variable to store the original items

    public ShopItemAdapter(Context context, List<shopBot> items) {
        this.context = context;
        this.items = new ArrayList<>(items); // Copy the original items to our adapter's list
        this.originalItems = new ArrayList<>(items); // Initialize the originalItems list
    }

    public void setItems(List<shopBot> filteredItems) {
        // Clear the current items in the adapter
        items.clear();

        // Add the filtered items to the adapter
        items.addAll(filteredItems);

        // Notify the adapter that the dataset has changed
        notifyDataSetChanged();
    }

    // Add a method to reset the adapter to show all original items
    public void resetItems() {
        items.clear();
        items.addAll(originalItems);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return items.size();
    }
}
