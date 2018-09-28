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
    private MyHolder.ItemClickListener listener;

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

    public void setListener(MyHolder.ItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new MyHolder(view, listener );
    }



    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.bindData(dataItems.get(position),picasso);
    }



    public static class MyHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imgAvatar)
        ImageView imgAvatar;

        @BindView(R.id.tvName)
        TextView tvName;

        private ItemClickListener listener;

        public MyHolder(View itemView, ItemClickListener listener) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            ButterKnife.bind(this,itemView);

            this.listener=listener;
        }

        public void bindData(final  DataItem dataItem,Picasso picasso){

            tvName.setText(dataItem.getFirstName() + dataItem.getLastName());
            picasso.load(dataItem.getAvatar()).into( imgAvatar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(dataItem);
                }
            });

        }


        public static interface ItemClickListener {
            void onClick(DataItem dataItem);


        }

    }


}
