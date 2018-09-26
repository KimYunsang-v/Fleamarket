package com.example.skuniv.fleamarket2.retrofit;

import com.example.skuniv.fleamarket2.model.AdminSellerModel.ApplyData;
import com.example.skuniv.fleamarket2.model.AdminSellerModel.UserModel;
import com.example.skuniv.fleamarket2.model.categoryModel.CategoryData;
import com.example.skuniv.fleamarket2.model.locatonModel.ShopData;
import com.example.skuniv.fleamarket2.model.noticeModel.NoticeData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("location/section/{section}/{sectionNum}")
    Call<ShopData> getListRepos(@Path("section") String section, @Path("sectionNum") int sectionNum);

    @GET("category/{middleCategory}/{pageNum}")
    Call<CategoryData> getGoodsRepos(@Path("middleCategory") int middleCategory ,@Path("pageNum") int pageNum);

    @GET("notice/select/{pageNum}")
    Call<NoticeData> getNoticeRepos(@Path("pageNum") int pageNum);

    @GET("notice/search/{type}/{keyword}/{page}")
    Call<NoticeData> getNoticeSearchRepos(@Path("type") String type,@Path("keyword") String keyword, @Path("page") int page);

    @POST("user/signin")
    Call<UserModel> getSignInRepos(@Field("id") String id, @Field("pw") String pw);

    @POST("user/signup")
    Call<String> getSignUnRepos(@Field("id") String id, @Field("pw") String pw, @Field("name") String name, @Field("sex") String sex, @Field("email") String email);

    @POST("user/findid")
    Call<UserModel> findIdRepos(@Field("name") String name, @Field("email") String email);

    @GET("apply/select/{list_num}")
    Call<ApplyData> getApplyRepos(@Field("list_num") int list_num);

    @GET("apply/random/{apply_count}/{list_num}")
    Call<ApplyData> randomApplyRepos(@Field("apply_count") int applyCount, @Field("list_num") int list_num);

    @GET("apply/firstcome/{apply_count}/{list_num}")
    Call<ApplyData> firstcomeApplyRepos(@Field("apply_count") int applyCount, @Field("list_num") int list_num);
}