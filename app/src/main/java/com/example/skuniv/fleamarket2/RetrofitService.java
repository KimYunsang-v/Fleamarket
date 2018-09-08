package com.example.skuniv.fleamarket2;

import com.example.skuniv.fleamarket2.model.ShopData;
import com.example.skuniv.fleamarket2.model.ShopModel;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("location/section/{section}/{sectionNum}")
    Call<ArrayList<ShopModel>> getListRepos(@Path("section") String section, @Path("sectionNum") int sectionNum);
}
