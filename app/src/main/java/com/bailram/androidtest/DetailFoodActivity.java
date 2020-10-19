package com.bailram.androidtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bailram.androidtest.generator.ServiceGenerator;
import com.bailram.androidtest.model.DetailMeal;
import com.bailram.androidtest.model.DetailMealResponse;
import com.bailram.androidtest.service.MealService;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailFoodActivity extends AppCompatActivity {
    private static final String TAG = "DetailFoodActivity";
    private TextView tIngr, tIngr1, tIngr2, tIngr3, tIngr4, tIngr5, tIngr6, tIngr7, tIngr8, tIngr9,
            tIngr10, tIngr11, tIngr12, tIngr13, tIngr14, tIngr15, tIngr16, tIngr17, tIngr18, tIngr19;
    private TextView tMeas, tMeas1, tMeas2, tMeas3, tMeas4, tMeas5, tMeas6, tMeas7, tMeas8, tMeas9,
            tMeas10, tMeas11, tMeas12, tMeas13, tMeas14, tMeas15, tMeas16, tMeas17, tMeas18, tMeas19;
    private TextView tTitle, tCategory, tArea, tInstruction;
    private List<DetailMeal> detailMeal;
    private MealService mealService;
    private ImageView imageView;
    private String idFood;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);

        setTitle("Detail Meal");

        // set navigation back icon toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // get intent
        Intent intent = getIntent();
        idFood = intent.getStringExtra(Constant.INTENT_IDFOOD);

        // define attribut
        mealService = ServiceGenerator.createService(MealService.class);
        imageView = findViewById(R.id.imageView_food);
        tTitle = findViewById(R.id.textView_title);
        tCategory = findViewById(R.id.textView_category);
        tArea = findViewById(R.id.textView_area);
        tInstruction = findViewById(R.id.textView_instructions);
        initIngrAndMeas();

        Call<DetailMealResponse> call = mealService.getDetailFood(idFood);
        call.enqueue(new Callback<DetailMealResponse>() {
            @Override
            public void onResponse(Call<DetailMealResponse> call, Response<DetailMealResponse> response) {
                detailMeal = response.body().getDetailMeals();
                Picasso.get()
                        .load(detailMeal.get(0).getStrMealThumb())
                        .into(imageView);
                tTitle.setText(detailMeal.get(0).getStrMeal());
                tCategory.setText(detailMeal.get(0).getStrCategory());
                tArea.setText(detailMeal.get(0).getStrArea());
                tInstruction.setText(detailMeal.get(0).getStrInstructions());
                setIngrAndMeas();
                Log.d(TAG, "GetDetailFoodStatus: succes");
            }

            @Override
            public void onFailure(Call<DetailMealResponse> call, Throwable t) {
                Log.e(TAG, "GetDetailFoodStatus: failed. "+t.getMessage());
            }
        });
    }

    private void initIngrAndMeas() {
        tIngr = findViewById(R.id.textView_ingr);
        tIngr1 = findViewById(R.id.textView_ingr2);
        tIngr2 = findViewById(R.id.textView_ingr3);
        tIngr3 = findViewById(R.id.textView_ingr4);
        tIngr4 = findViewById(R.id.textView_ingr5);
        tIngr5 = findViewById(R.id.textView_ingr6);
        tIngr6 = findViewById(R.id.textView_ingr7);
        tIngr7 = findViewById(R.id.textView_ingr8);
        tIngr8 = findViewById(R.id.textView_ingr9);
        tIngr9 = findViewById(R.id.textView_ingr10);
        tIngr10 = findViewById(R.id.textView_ingr11);
        tIngr11 = findViewById(R.id.textView_ingr12);
        tIngr12 = findViewById(R.id.textView_ingr13);
        tIngr13 = findViewById(R.id.textView_ingr14);
        tIngr14 = findViewById(R.id.textView_ingr15);
        tIngr15 = findViewById(R.id.textView_ingr16);
        tIngr16 = findViewById(R.id.textView_ingr17);
        tIngr17 = findViewById(R.id.textView_ingr18);
        tIngr18 = findViewById(R.id.textView_ingr19);
        tIngr19 = findViewById(R.id.textView_ingr20);
        tMeas = findViewById(R.id.textView_meas);
        tMeas1 = findViewById(R.id.textView_meas2);
        tMeas2 = findViewById(R.id.textView_meas3);
        tMeas3 = findViewById(R.id.textView_meas4);
        tMeas4 = findViewById(R.id.textView_meas5);
        tMeas5 = findViewById(R.id.textView_meas6);
        tMeas6 = findViewById(R.id.textView_meas7);
        tMeas7 = findViewById(R.id.textView_meas8);
        tMeas8 = findViewById(R.id.textView_meas9);
        tMeas9 = findViewById(R.id.textView_meas10);
        tMeas10 = findViewById(R.id.textView_meas11);
        tMeas11 = findViewById(R.id.textView_meas12);
        tMeas12 = findViewById(R.id.textView_meas13);
        tMeas13 = findViewById(R.id.textView_meas14);
        tMeas14 = findViewById(R.id.textView_meas15);
        tMeas15 = findViewById(R.id.textView_meas16);
        tMeas16 = findViewById(R.id.textView_meas17);
        tMeas17 = findViewById(R.id.textView_meas18);
        tMeas18 = findViewById(R.id.textView_meas19);
        tMeas19 = findViewById(R.id.textView_meas20);
    }

    private void setIngrAndMeas(){
        checkAndSetTIngrAndMeas(tIngr,detailMeal.get(0).getStrIngredient1());
        checkAndSetTIngrAndMeas(tIngr1,detailMeal.get(0).getStrIngredient2());
        checkAndSetTIngrAndMeas(tIngr2,detailMeal.get(0).getStrIngredient3());
        checkAndSetTIngrAndMeas(tIngr3,detailMeal.get(0).getStrIngredient4());
        checkAndSetTIngrAndMeas(tIngr4,detailMeal.get(0).getStrIngredient5());
        checkAndSetTIngrAndMeas(tIngr5,detailMeal.get(0).getStrIngredient6());
        checkAndSetTIngrAndMeas(tIngr6,detailMeal.get(0).getStrIngredient7());
        checkAndSetTIngrAndMeas(tIngr7,detailMeal.get(0).getStrIngredient8());
        checkAndSetTIngrAndMeas(tIngr8,detailMeal.get(0).getStrIngredient9());
        checkAndSetTIngrAndMeas(tIngr9,detailMeal.get(0).getStrIngredient10());
        checkAndSetTIngrAndMeas(tIngr10,detailMeal.get(0).getStrIngredient11());
        checkAndSetTIngrAndMeas(tIngr11,detailMeal.get(0).getStrIngredient12());
        checkAndSetTIngrAndMeas(tIngr12,detailMeal.get(0).getStrIngredient13());
        checkAndSetTIngrAndMeas(tIngr13,detailMeal.get(0).getStrIngredient14());
        checkAndSetTIngrAndMeas(tIngr14,detailMeal.get(0).getStrIngredient15());
        checkAndSetTIngrAndMeas(tIngr15,detailMeal.get(0).getStrIngredient16());
        checkAndSetTIngrAndMeas(tIngr16,detailMeal.get(0).getStrIngredient17());
        checkAndSetTIngrAndMeas(tIngr17,detailMeal.get(0).getStrIngredient18());
        checkAndSetTIngrAndMeas(tIngr18,detailMeal.get(0).getStrIngredient19());
        checkAndSetTIngrAndMeas(tIngr19,detailMeal.get(0).getStrIngredient20());
        checkAndSetTIngrAndMeas(tMeas,detailMeal.get(0).getStrMeasure1());
        checkAndSetTIngrAndMeas(tMeas1,detailMeal.get(0).getStrMeasure2());
        checkAndSetTIngrAndMeas(tMeas2,detailMeal.get(0).getStrMeasure3());
        checkAndSetTIngrAndMeas(tMeas3,detailMeal.get(0).getStrMeasure4());
        checkAndSetTIngrAndMeas(tMeas4,detailMeal.get(0).getStrMeasure5());
        checkAndSetTIngrAndMeas(tMeas5,detailMeal.get(0).getStrMeasure6());
        checkAndSetTIngrAndMeas(tMeas6,detailMeal.get(0).getStrMeasure7());
        checkAndSetTIngrAndMeas(tMeas7,detailMeal.get(0).getStrMeasure8());
        checkAndSetTIngrAndMeas(tMeas8,detailMeal.get(0).getStrMeasure9());
        checkAndSetTIngrAndMeas(tMeas9,detailMeal.get(0).getStrMeasure10());
        checkAndSetTIngrAndMeas(tMeas10,detailMeal.get(0).getStrMeasure11());
        checkAndSetTIngrAndMeas(tMeas11,detailMeal.get(0).getStrMeasure12());
        checkAndSetTIngrAndMeas(tMeas12,detailMeal.get(0).getStrMeasure13());
        checkAndSetTIngrAndMeas(tMeas13,detailMeal.get(0).getStrMeasure14());
        checkAndSetTIngrAndMeas(tMeas14,detailMeal.get(0).getStrMeasure15());
        checkAndSetTIngrAndMeas(tMeas15,detailMeal.get(0).getStrMeasure16());
        checkAndSetTIngrAndMeas(tMeas16,detailMeal.get(0).getStrMeasure17());
        checkAndSetTIngrAndMeas(tMeas17,detailMeal.get(0).getStrMeasure18());
        checkAndSetTIngrAndMeas(tMeas18,detailMeal.get(0).getStrMeasure19());
        checkAndSetTIngrAndMeas(tMeas19,detailMeal.get(0).getStrMeasure20());
    }

    private void checkAndSetTIngrAndMeas(TextView textView, String value){
        if(value != null && !value.equalsIgnoreCase("")){
            textView.setText(value);
        }else{
            textView.setVisibility(View.GONE);
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}