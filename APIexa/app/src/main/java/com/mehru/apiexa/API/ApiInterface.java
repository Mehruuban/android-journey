package com.mehru.apiexa.API;

import com.mehru.apiexa.Model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface  {
    @GET("/photos")
    Call<List<Model>> getData();
}
