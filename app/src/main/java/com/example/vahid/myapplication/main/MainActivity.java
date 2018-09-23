package com.example.vahid.myapplication.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.vahid.myapplication.R;
import com.example.vahid.myapplication.net.ApiService;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Picasso picasso;

    @Inject
    public ApiService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img = findViewById(R.id.img);

        App.getComponent().injdect2(this);
        picasso.load("http://square.github.io/picasso/static/sample.png").into(img);


    }
}
