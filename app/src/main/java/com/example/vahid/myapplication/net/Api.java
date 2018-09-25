package com.example.vahid.myapplication.net;

import com.example.vahid.myapplication.net.model.MovieModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface Api {

    @GET("api/users")
    Call<MovieModel>getMovie(@Query("page") Integer page);

}
