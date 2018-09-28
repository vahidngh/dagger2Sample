package com.example.vahid.myapplication.main.app.dagger2.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import com.example.vahid.myapplication.main.app.App;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vahid on 9/27/18.
 */
@Module
public class AndroidModule {

        private App app;


    public AndroidModule(App app) {
        this.app = app;
    }

    @Provides
    public Context context(){
        return app.getApplicationContext();
    }

    @Provides
    public Resources resources(){
        return app.getResources();
    }

    @Provides
    public SharedPreferences sharedPreferences(){
        return PreferenceManager.getDefaultSharedPreferences(app);
    }
}
