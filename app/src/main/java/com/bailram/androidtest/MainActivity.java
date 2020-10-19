package com.bailram.androidtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bailram.androidtest.adapter.ListMealAdapter;
import com.bailram.androidtest.generator.ServiceGenerator;
import com.bailram.androidtest.model.ListMeal;
import com.bailram.androidtest.model.ListMealResponse;
import com.bailram.androidtest.service.MealService;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private CarouselView carouselView;
    private MealService mealService;
    private List<ListMeal> mealList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("List Meal");

        // define attribute
        recyclerView = findViewById(R.id.recyclerview_grid_meal);
        carouselView = findViewById(R.id.carouselView_meal);

        mealService = ServiceGenerator.createService(MealService.class);
        Call<ListMealResponse> call = mealService.getFoodSeafoodCategory();
        call.enqueue(new Callback<ListMealResponse>() {
            @Override
            public void onResponse(Call<ListMealResponse> call, Response<ListMealResponse> response) {
                mealList = response.body().getListMeals();
                // set recycler view
                ListMealAdapter adapter = new ListMealAdapter(MainActivity.this,mealList);
                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(layoutManager);
                Log.d(TAG, "ListMealSize: "+mealList.size());
                // set carousel view
                carouselView.setImageListener(imageListener);
                carouselView.setImageClickListener(imageClickListener);
                carouselView.setPageCount(mealList.size());

            }

            @Override
            public void onFailure(Call<ListMealResponse> call, Throwable t) {
                Log.e(TAG, "GetFoodStatus: failed. "+t.toString());
            }
        });

    }

    private ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            Picasso.get()
                    .load(mealList.get(position).getStrMealThumb())
                    .into(imageView);
        }
    };

    private ImageClickListener imageClickListener = new ImageClickListener() {
        @Override
        public void onClick(int position) {
//            Toast.makeText(getApplicationContext(), "Clicked Carousel", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(),DetailFoodActivity.class);
            i.putExtra(Constant.INTENT_IDFOOD,mealList.get(position).getIdMeal());
            startActivity(i);
        }
    };
}