package com.example.vahid.myapplication.main.dagger2;

import com.example.vahid.myapplication.main.MainActivity;
import com.example.vahid.myapplication.main.dagger2.module.PicassoModule;
import com.example.vahid.myapplication.main.dagger2.module.retrofitModule;

import dagger.Component;

@Component (modules = {
        PicassoModule.class,
        retrofitModule.class})

public interface ApplicationComponent {

    void injdect2(MainActivity mainActivity);

}

