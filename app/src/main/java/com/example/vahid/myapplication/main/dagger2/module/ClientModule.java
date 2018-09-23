package com.example.vahid.myapplication.main.dagger2.module;


import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;


@Module (includes = ContextModule.class)
public class ClientModule {



    @Provides
    public OkHttpClient client(Cache cache){
        return new OkHttpClient.Builder()
                .cache(cache)
                .build();
    }

    @Provides
    public Cache cache(File file){
        return new Cache(file,5*1024*1024);
    }


    @Provides
    public File file(Context context){
        return new File(context.getCacheDir(),"OkHttpClient");
    }

}
