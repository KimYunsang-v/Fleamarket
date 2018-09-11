package com.example.skuniv.fleamarket2.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.util.Log;
import com.example.skuniv.fleamarket2.NetRetrofit;
import com.example.skuniv.fleamarket2.RetrofitService;
import com.example.skuniv.fleamarket2.databinding.ActivitySectionBinding;
import com.example.skuniv.fleamarket2.model.Goods;
import com.example.skuniv.fleamarket2.model.SectionModel;
import com.example.skuniv.fleamarket2.model.ShopData;
import com.example.skuniv.fleamarket2.model.ShopModel;
import com.example.skuniv.fleamarket2.view.LocationActivity;
import com.example.skuniv.fleamarket2.view.ShopSelectDialog;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SectionCommand {

    SectionModel sectionModel;
    ShopSelectDialog shopSelectDialog;
    ActivitySectionBinding sectionBinding;
    ShopsViewModel shopsViewModel;
    ShopData shopData;
    List<ShopModel> shops = new ArrayList<ShopModel>();
    Gson gson = new Gson();



    public SectionCommand(SectionModel sectionModel, ActivitySectionBinding sectionBinding,ShopsViewModel shopsViewModel) {
        this.sectionModel = sectionModel;
        this.sectionBinding = sectionBinding;
        this.shopsViewModel = shopsViewModel;
    }

   /* public void selectDialog(View view) {
        //shopSelectDialog = new ShopSelectDialog();
        shopSelectDialog.show();
    }*/

    public List<ShopModel> getShopList() {
        if (!(sectionModel.getSection().isEmpty()) && !sectionModel.getSectionNum().isEmpty()) {
            Call<List<ShopModel>> res = NetRetrofit.getInstance().getService().getListRepos(sectionModel.getSection(),sectionModel.getSectionNum());
            Log.i("getShopList",""+res);
            res.enqueue(new Callback<List<ShopModel>>() {
                @Override
                public void onResponse(Call<List<ShopModel>> call, Response<List<ShopModel>> response) {
                    Log.i("Retrofit", response.toString());
                    if (response.body() != null) {
                        shops = response.body();
                        Log.i("getShopList",""+gson.toJson(response.body()));
                        shopsViewModel.setShops(shops);
                    }
                }
                @Override
                public void onFailure(Call<List<ShopModel>> call, Throwable t) {
                    Log.e("에러", t.getMessage());
                }
            });
        } else {
            Log.e("getShopList","getShopList error");
        }
        return shops;
    }

    public List<ShopModel> jsonPaser(String jsonObject){

        Gson gson = new Gson();
        ShopModel[] shopList = gson.fromJson(jsonObject,  ShopModel[].class);

        List<ShopModel> shops = new ArrayList<>(Arrays.asList(shopList));

        // shops = shopData.getShops();

        return shops;
    }

}