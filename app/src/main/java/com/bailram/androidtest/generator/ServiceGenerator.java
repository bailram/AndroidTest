package com.bailram.androidtest.generator;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static final String BASE_URL = "https://www.themealdb.com/";

    public ServiceGenerator(){ }

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    // use to intercept request/response HTTP
    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);


    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public static <Service> Service createService(Class<Service> serviceClass){
        if(!httpClient.interceptors().contains(loggingInterceptor)){
            httpClient.addInterceptor(loggingInterceptor);
            builder.client(httpClient.build());
            retrofit = builder.build();
        }
        return retrofit.create(serviceClass);
    }
}
