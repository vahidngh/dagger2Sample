package com.example.vahid.myapplication.main.activities.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vahid.myapplication.R;
import com.example.vahid.myapplication.main.activities.user.dagger2.DaggerUserComponent;
import com.example.vahid.myapplication.main.app.App;
import com.example.vahid.myapplication.main.app.dagger2.ApplicationComponent;
import com.example.vahid.myapplication.net.model.DataItem;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetail extends AppCompatActivity {


    @BindView(R.id.imgAvatar)
    ImageView imgAvatar;

    @BindView(R.id.tvName)
    TextView tvName;

    @Inject
    Picasso picasso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerUserComponent.builder()
                .applicationComponent(App.getComponent())
                .build()
                .inject1(this);

        setContentView(R.layout.activity_user_detail);
        ButterKnife.bind(this);

        DataItem dataItem = Parcels.unwrap(getIntent().getParcelableExtra("data"));

        tvName.setText(dataItem.getFirstName() + " " + dataItem.getLastName());

        picasso.load(dataItem.getAvatar()).into(imgAvatar);

    }
}
