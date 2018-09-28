package com.example.vahid.myapplication.main.app.dagger2.module;

import com.example.vahid.myapplication.common.Config;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vahid on 9/27/18.
 */

@Module
public class ApplicationModule {

    @Provides
    @Named("url")
    public String url(){
        return Config.URL;
    }


    @Provides
    @Named("cacheMaxSize")
    public Integer cacheMaxSize(){
        return Config.CACHE_MAX_SIZE;
    }





}
