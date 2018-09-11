package com.example.vahid.myapplication.main.dagger2.module;

import android.content.Context;

import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;


@Module
public class PicassoModule {

    private Context context;

    public PicassoModule(Context context) {
        this.context = context;
    }

    @Provides
    public Picasso picasso(){
        return new Picasso.Builder(context).build();
    }

}
