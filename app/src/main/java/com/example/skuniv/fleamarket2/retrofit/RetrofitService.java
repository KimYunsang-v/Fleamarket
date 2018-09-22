package com.example.skuniv.fleamarket2.retrofit;

import com.example.skuniv.fleamarket2.model.categoryModel.CategoryData;
import com.example.skuniv.fleamarket2.model.categoryModel.CategoryShopModel;
import com.example.skuniv.fleamarket2.model.locatonModel.ShopData;
import com.example.skuniv.fleamarket2.model.locatonModel.ShopModel;
import com.example.skuniv.fleamarket2.model.noticeModel.NoticeData;
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
    Call<ShopData> getListRepos(@Path("section") String section, @Path("sectionNum") String sectionNum);

    @GET("category/{category}/{pageNum}")
    Call<CategoryData> getGoodsRepos(@Path("category") String category, @Path("pageNum") int pageNum);

    @GET("notice/select/{pageNum}")
    Call<NoticeData> getNoticeRepos(@Path("pageNum") int pageNum);

    @GET("notice/search/{type}/{keyword}")
    Call<NoticeData> getNoticeSearchRepos(@Path("type") String type,@Path("keyword") String keyword);



}