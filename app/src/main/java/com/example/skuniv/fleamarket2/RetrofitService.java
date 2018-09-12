package com.example.skuniv.fleamarket2;

import com.example.skuniv.fleamarket2.model.Goods;
import com.example.skuniv.fleamarket2.model.ShopData;
import com.example.skuniv.fleamarket2.model.ShopModel;
import com.example.skuniv.fleamarket2.viewmodel.ShopViewModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("location/section/{section}/{sectionNum}")
    Call<List<ShopModel>> getListRepos(@Path("section") String section, @Path("sectionNum") String sectionNum);

    @GET("category/{category}/{pageNum}")
    Call<List<Goods>> getGoodsRepos(@Path("category") String category, @Path("pageNum") int pageNum);
}