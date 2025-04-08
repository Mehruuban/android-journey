package com.mehru.api;

import static com.mehru.api.MainActivity.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static  RetrofitInstance retrofitInstance ;
    ApiInterface apiInterface;

    RetrofitInstance(){


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface= retrofit.create(ApiInterface.class);
    }

    public static RetrofitInstance getInstance() {
        return null;
    }

    public RetrofitInstance Instance() {
        if (retrofitInstance==null){
            retrofitInstance = new RetrofitInstance();
        }
        return retrofitInstance;
    }

}
