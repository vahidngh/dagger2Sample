package com.example.vahid.myapplication.net.data;

import com.example.vahid.myapplication.net.ApiService;
import com.example.vahid.myapplication.net.model.DataItem;
import com.example.vahid.myapplication.net.model.MovieModel;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManagementData {

    private ApiService api;
    private CacheData cache;

    @Inject
    public ManagementData(ApiService api, CacheData cache) {
        this.api = api;
        this.cache = cache;
    }

    public void getDataNet(Integer page, final onCallback callback) {

        String key = "page='" + page + "'";

        if (cache.get(key) != null) {

            List<DataItem> dataItems = ((MovieModel) cache.get(key)).getData();


        } else {
            api.getMovieCall(page).enqueue(new Callback<MovieModel>() {
                @Override
                public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                    callback.data(response.body().getData());
                    String key = "pages'"+response.body().getPage()+"'";
                    cache.add(key,response.body().getData());
                }

                @Override
                public void onFailure(Call<MovieModel> call, Throwable t) {
                    callback.error(t.getMessage());
                }
            });

        }
    }


    public interface onCallback {
        void data(List<DataItem> dataItems);

        void error(String msg);
    }


}
