package com.mehru.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    Call<List<Model>> getData();

    public interface apiInterface {
        @GET("/photos")
        Call<List<Model>> getData();
    }

}
