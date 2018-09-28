package com.example.vahid.myapplication.main.activities.user.dagger2;

import com.example.vahid.myapplication.main.activities.user.UserDetail;
import com.example.vahid.myapplication.main.app.dagger2.ApplicationComponent;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by vahid on 9/28/18.
 */
@Component (dependencies = ApplicationComponent.class)
public interface UserComponent {

//    Picasso getPicasso();

    void inject1(UserDetail userDetail);

}
