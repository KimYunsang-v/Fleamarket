package com.example.skuniv.fleamarket2.viewmodel;

import android.content.Context;
import android.util.Log;
import com.example.skuniv.fleamarket2.NetRetrofit;
import com.example.skuniv.fleamarket2.databinding.ActivitySectionBinding;
import com.example.skuniv.fleamarket2.model.SectionModel;
import com.example.skuniv.fleamarket2.model.ShopData;
import com.example.skuniv.fleamarket2.model.ShopModel;
import com.example.skuniv.fleamarket2.view.ShopSelectDialog;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SectionCommand {

    SectionModel sectionModel;
    ShopSelectDialog shopSelectDialog;
    ActivitySectionBinding sectionBinding;
    Context context;
    ShopData shopData;


    public SectionCommand(SectionModel sectionModel, ActivitySectionBinding sectionBinding) {
        this.sectionModel = sectionModel;
        this.sectionBinding = sectionBinding;
    }

   /* public void selectDialog(View view) {
        //shopSelectDialog = new ShopSelectDialog();
        shopSelectDialog.show();
    }*/

    public void getShopList() {
        if (!(sectionModel.getSection().isEmpty()) && sectionModel.getSectionNum() >= 0) {
            Call<ArrayList<ShopModel>> res = NetRetrofit.getInstance().getService().getListRepos(sectionModel.getSection(), 1);
            Log.i("getShopList","getShopList start ========");
            res.enqueue(new Callback<ArrayList<ShopModel>>() {
                @Override
                public void onResponse(Call<ArrayList<ShopModel>> call, Response<ArrayList<ShopModel>> response) {
                    Log.d("Retrofit", response.toString());
                    if (response.body() != null) {
                        shopData.setShops(response.body());
                        //Log.i("getShopList",""+response.body());
                    }
                }
                @Override
                public void onFailure(Call<ArrayList<ShopModel>> call, Throwable t) {
                    Log.e("Err", t.getMessage());
                }
            });
        } else {
            Log.e("getShopList","getShopList error");
        }
    }
}
