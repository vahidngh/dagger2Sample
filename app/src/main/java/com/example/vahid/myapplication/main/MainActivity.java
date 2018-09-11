package com.example.vahid.myapplication.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.vahid.myapplication.R;
import com.example.vahid.myapplication.main.dagger2.ApplicationComponent;
import com.example.vahid.myapplication.main.dagger2.DaggerApplicationComponent;
import com.example.vahid.myapplication.main.dagger2.module.PicassoModule;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApplicationComponent component = DaggerApplicationComponent.builder().picassoModule(new PicassoModule(this)).build();

        ImageView img = findViewById(R.id.img);

        Picasso picasso = component.getPicasso();
        picasso.load("http://square.github.io/picasso/static/sample.png").into(img);

    }
}
