package com.example.vahid.myapplication.main.app.dagger2.module;

import com.example.vahid.myapplication.common.Config;
import com.example.vahid.myapplication.net.Api;
import com.example.vahid.myapplication.net.ApiService;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ClientModule.class)
public class retrofitModule {


    @Provides
    public ApiService apiService(Retrofit retrofit){
        return new ApiService(retrofit.create(Api.class));
    }

    @Provides
    public Retrofit retrofit(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(Config.URL)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
}
