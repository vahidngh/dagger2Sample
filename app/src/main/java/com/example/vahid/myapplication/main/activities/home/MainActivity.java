package com.example.vahid.myapplication.main.activities.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.vahid.myapplication.R;
import com.example.vahid.myapplication.main.activities.user.UserDetail;
import com.example.vahid.myapplication.main.adapter.DataAdapter;
import com.example.vahid.myapplication.main.app.App;
import com.example.vahid.myapplication.net.ApiService;
import com.example.vahid.myapplication.net.data.ManagementData;
import com.example.vahid.myapplication.net.model.DataItem;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView rv;


    @Inject
    DataAdapter adapter;

    @Inject
    public ApiService service;

    @Inject
    public ManagementData managementData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getComponent().injdect2(this);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        managementData.getDataNet(0, new ManagementData.onCallback() {
            @Override
            public void data(List<DataItem> dataItems) {

                adapter.setDataItems(dataItems);
                rv.setAdapter(adapter);

            }

            @Override
            public void error(String msg) {

            }
        });

        adapter.setListener(new DataAdapter.MyHolder.ItemClickListener() {
            @Override
            public void onClick(DataItem dataItem) {
                Intent intent = new Intent(MainActivity.this, UserDetail.class);
                intent.putExtra("data", Parcels.wrap(dataItem));
                startActivity(intent);
            }
        });

    }
}
