package com.example.skuniv.fleamarket2.retrofit;

import com.example.skuniv.fleamarket2.model.categoryModel.CategoryShopModel;
import com.example.skuniv.fleamarket2.model.locatonModel.ShopModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("location/section/{section}/{sectionNum}")
    Call<List<ShopModel>> getListRepos(@Path("section") String section, @Path("sectionNum") String sectionNum);

    @GET("category/{category}/{pageNum}")
    Call<List<CategoryShopModel>> getGoodsRepos(@Path("category") String category, @Path("pageNum") int pageNum);
}