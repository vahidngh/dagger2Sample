package com.example.vahid.myapplication.main.app.dagger2.module;

import com.example.vahid.myapplication.common.Config;
import com.example.vahid.myapplication.net.data.CacheData;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class CacheDataModule {

    @Provides
    public CacheData cacheData(@Named("cacheMaxSize") Integer cacheMaxSize){
        return new CacheData(cacheMaxSize);
    }
}
