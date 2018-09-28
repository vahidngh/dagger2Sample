package com.example.vahid.myapplication.main.app.dagger2;

import com.example.vahid.myapplication.main.activities.home.MainActivity;
import com.example.vahid.myapplication.main.app.dagger2.module.AndroidModule;
import com.example.vahid.myapplication.main.app.dagger2.module.ApplicationModule;
import com.example.vahid.myapplication.main.app.dagger2.module.CacheDataModule;
import com.example.vahid.myapplication.main.app.dagger2.module.PicassoModule;
import com.example.vahid.myapplication.main.app.dagger2.module.retrofitModule;
import com.squareup.picasso.Picasso;

import dagger.Component;

@Component (modules = {
        PicassoModule.class ,
        retrofitModule.class,
        CacheDataModule.class,
        AndroidModule.class,
        ApplicationModule.class })

public interface ApplicationComponent {

    void injdect2(MainActivity mainActivity);

    Picasso getPcasso();

}