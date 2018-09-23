package com.example.vahid.myapplication.main.dagger2;

import com.example.vahid.myapplication.main.MainActivity;
import com.example.vahid.myapplication.main.dagger2.module.PicassoModule;

import dagger.Component;

@Component (modules = PicassoModule.class)
public interface ApplicationComponent {

//    Picasso getPicasso();
    void injdect2(MainActivity mainActivity);

}
