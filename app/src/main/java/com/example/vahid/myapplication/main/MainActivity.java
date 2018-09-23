package com.example.vahid.myapplication.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.vahid.myapplication.R;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Picasso picasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img = findViewById(R.id.img);

//        ApplicationComponent component = DaggerApplicationComponent.builder().picassoModule(new PicassoModule(this)).build();

//        App app = new App();
//        picasso = app.getPicasso();


        App.getComponent().injdect2(this);
        picasso.load("http://square.github.io/picasso/static/sample.png").into(img);


    }
}
