package com.example.skuniv.fleamarket2.retrofit;

import com.example.skuniv.fleamarket2.model.categoryModel.CategoryShopModel;
import com.example.skuniv.fleamarket2.model.locatonModel.ShopModel;
import com.example.skuniv.fleamarket2.model.noticeModel.NoticeModel;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface RetrofitService {
    @GET("location/section/{section}/{sectionNum}")
    Call<List<ShopModel>> getListRepos(@Path("section") String section, @Path("sectionNum") String sectionNum);

    @GET("category/{category}/{pageNum}")
    Call<List<CategoryShopModel>> getGoodsRepos(@Path("category") String category, @Path("pageNum") int pageNum);

    @GET("notice/select/{pageNum}")
    Call<List<NoticeModel>> getNoticeRepos(@Path("pageNum") int pageNum);



}