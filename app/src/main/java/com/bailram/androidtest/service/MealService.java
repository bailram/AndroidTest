package com.bailram.androidtest.service;

import com.bailram.androidtest.model.DetailMealResponse;
import com.bailram.androidtest.model.ListMealResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealService {
    @GET("api/json/v1/1/filter.php?c=Seafood")
    Call<ListMealResponse> getFoodSeafoodCategory();

    @GET("api/json/v1/1/lookup.php")
    Call<DetailMealResponse> getDetailFood(@Query("i") String idFood);
}
