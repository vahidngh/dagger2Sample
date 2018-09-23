package com.example.vahid.myapplication.main;

import android.app.Application;

import com.example.vahid.myapplication.main.dagger2.ApplicationComponent;
import com.example.vahid.myapplication.main.dagger2.DaggerApplicationComponent;
import com.example.vahid.myapplication.main.dagger2.module.ContextModule;

public class App extends Application {

    static ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        //equals to above  code
//        component = DaggerApplicationComponent.builder()
//                .picassoModule(new PicassoModule())
//                .clientModule(new ClientModule())
//                .contextModule(new ContextModule(this))
//                .build();





    }


    public static ApplicationComponent getComponent() {
        return component;
    }

}
