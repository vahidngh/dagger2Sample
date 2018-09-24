package com.example.vahid.myapplication.main.activities.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.vahid.myapplication.R;
import com.example.vahid.myapplication.main.app.App;
import com.example.vahid.myapplication.net.ApiService;
import com.example.vahid.myapplication.net.data.ManagementData;
import com.example.vahid.myapplication.net.model.DataItem;
import com.example.vahid.myapplication.net.model.MovieModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Picasso picasso;

    @Inject
    public ApiService service;

    @Inject
    public ManagementData managementData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img = findViewById(R.id.img);

        App.getComponent().injdect2(this);
        picasso.load("http://square.github.io/picasso/static/sample.png").into(img);




        managementData.getDataNet(0, new ManagementData.onCallback() {
            @Override
            public void data(List<DataItem> dataItems) {

            }

            @Override
            public void error(String msg) {

            }
        });

    }
}
