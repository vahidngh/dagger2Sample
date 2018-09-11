package com.example.vahid.myapplication.main.dagger2;

import com.example.vahid.myapplication.main.dagger2.module.PicassoModule;
import com.squareup.picasso.Picasso;

import dagger.Component;

@Component (modules = PicassoModule.class)
public interface ApplicationComponent {

    Picasso getPicasso();

}
