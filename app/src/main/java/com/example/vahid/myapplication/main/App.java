package com.example.vahid.myapplication.main;

import android.app.Application;

import com.example.vahid.myapplication.main.dagger2.ApplicationComponent;
import com.example.vahid.myapplication.main.dagger2.DaggerApplicationComponent;
import com.example.vahid.myapplication.main.dagger2.module.PicassoModule;

public class App extends Application {

//    private Picasso picasso;

    static ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .picassoModule(new PicassoModule(this))
                .build();


        //component.injdect2();


        //picasso = component.getPicasso();

    }


    public static ApplicationComponent getComponent(){
        return component;
    }

//    public Picasso getPicasso(){
//        return picasso;
//    }

}
