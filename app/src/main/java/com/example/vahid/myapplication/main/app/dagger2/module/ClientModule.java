package com.example.vahid.myapplication.main.app.dagger2.module;


import android.content.Context;

import java.io.File;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;


@Module
public class ClientModule {



    @Provides
    public OkHttpClient client(Cache cache){
        return new OkHttpClient.Builder()
                .cache(cache)
                .build();
    }

    @Provides
    public Cache cache(File file, @Named("cacheMaxSize")Integer cacheMaxSize){
        return new Cache(file,cacheMaxSize);
    }


    @Provides
    public File file(Context context){
        return new File(context.getCacheDir(),"OkHttpClient");
    }

}
