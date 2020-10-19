package com.bailram.androidtest.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bailram.androidtest.Constant;
import com.bailram.androidtest.DetailFoodActivity;
import com.bailram.androidtest.MainActivity;
import com.bailram.androidtest.R;
import com.bailram.androidtest.model.ListMeal;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListMealAdapter extends RecyclerView.Adapter<ListMealAdapter.ListMealViewHolder> {
    private List<ListMeal> meals;
    private MainActivity context;

    public ListMealAdapter(MainActivity context, List<ListMeal> meals){
        this.context = context;
        this.meals = meals;
    }

    @NonNull
    @Override
    public ListMealAdapter.ListMealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_meal, parent, false);
        return new ListMealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListMealAdapter.ListMealViewHolder holder, final int position) {
        Picasso.get()
                .load(meals.get(position).getStrMealThumb())
                .into(holder.iItem);
        holder.tItem.setText(meals.get(position).getStrMeal());
        holder.lItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context.getApplicationContext(), "Clicked", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context.getApplicationContext(), DetailFoodActivity.class);
                i.putExtra(Constant.INTENT_IDFOOD, meals.get(position).getIdMeal());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public class ListMealViewHolder extends RecyclerView.ViewHolder {
        LinearLayout lItem;
        ImageView iItem;
        TextView tItem;
        public ListMealViewHolder(@NonNull View itemView) {
            super(itemView);
            lItem = itemView.findViewById(R.id.linearLayout_item);
            iItem = itemView.findViewById(R.id.imageView_item);
            tItem = itemView.findViewById(R.id.textView_title);
        }
    }
}
