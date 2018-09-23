package com.example.vahid.myapplication.main.dagger2.module;

import android.content.Context;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;


@Module(includes = {ContextModule.class,ClientModule.class})
public class PicassoModule {



    @Provides
    public Picasso picasso(Context context,OkHttp3Downloader downloader){
        return new Picasso.Builder(context)
                .downloader(downloader)
                .build();
    }

    @Provides
     public OkHttp3Downloader downloader(OkHttpClient client){
        return new OkHttp3Downloader(client);
     }


}
