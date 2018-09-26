package com.example.vahid.myapplication.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vahid.myapplication.R;
import com.example.vahid.myapplication.net.model.DataItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyHolder> {

    private List<DataItem> dataItems = new ArrayList<>();
    private Context context;
    private Picasso picasso;

    @Inject
    public DataAdapter(Context context, Picasso picasso) {
        this.context = context;
        this.picasso = picasso;
    }

    public void setDataItems(@NonNull List<DataItem> dataItems) {
        this.dataItems = dataItems;
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new MyHolder(view);
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imgAvatar)
        ImageView imgAvatar;

        @BindView(R.id.tvName)
        TextView tvName;

        public MyHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this.itemView);
        }
    }


    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tvName.setText(dataItems.get(position).getFirstName() + dataItems.get(position).getLastName());
        picasso.load(dataItems.get(position).getAvatar()).into(holder.imgAvatar);
    }

}
