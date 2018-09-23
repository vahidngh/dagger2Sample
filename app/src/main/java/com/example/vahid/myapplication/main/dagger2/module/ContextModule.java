package com.example.vahid.myapplication.main.dagger2.module;

import android.app.Activity;
import android.content.Context;

import com.example.vahid.myapplication.main.App;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private App app;

    public ContextModule(App app) {
        this.app = app;
    }

    @Provides
    public Context context(){
        return app.getApplicationContext();
    }
}
