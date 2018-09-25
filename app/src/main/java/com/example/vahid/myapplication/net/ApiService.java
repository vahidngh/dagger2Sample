package com.example.vahid.myapplication.net;

import com.example.vahid.myapplication.net.model.MovieModel;

import retrofit2.Call;

public class ApiService {

    private Api api;

    public ApiService(Api api) {
        this.api = api;
    }

    public Call<MovieModel> getMovieCall(Integer page) {
        return api.getMovie(page);
    }
}