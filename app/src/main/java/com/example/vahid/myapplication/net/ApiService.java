package com.example.vahid.myapplication.net;

import retrofit2.Call;

public class ApiService {

    private Api api;

    public ApiService(Api api) {
        this.api = api;
    }


    public Call<String> getCheckServer(Api api){
        return api.getCheckServer("","","","");
    }
}