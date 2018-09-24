package com.example.vahid.myapplication.main.app.dagger2.module;

import com.example.vahid.myapplication.common.Config;
import com.example.vahid.myapplication.net.data.CacheData;

import dagger.Module;
import dagger.Provides;

@Module
public class CacheDataModule {

    @Provides
    public CacheData cacheData(){
        return new CacheData(Config.CACHE_MAX_SIZE);
    }
}
