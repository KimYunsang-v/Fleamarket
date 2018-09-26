package com.example.skuniv.fleamarket2.retrofit;

import com.example.skuniv.fleamarket2.model.AdminSellerModel.ApplyData;
import com.example.skuniv.fleamarket2.model.AdminSellerModel.UserModel;
import com.example.skuniv.fleamarket2.model.categoryModel.CategoryData;
import com.example.skuniv.fleamarket2.model.jsonModel.ApplyOneJson;
import com.example.skuniv.fleamarket2.model.jsonModel.FindIdJson;
import com.example.skuniv.fleamarket2.model.jsonModel.ResponseJson;
import com.example.skuniv.fleamarket2.model.jsonModel.SignInJson;
import com.example.skuniv.fleamarket2.model.jsonModel.SignUpJson;
import com.example.skuniv.fleamarket2.model.locatonModel.ShopData;
import com.example.skuniv.fleamarket2.model.locatonModel.ShopModel;
import com.example.skuniv.fleamarket2.model.noticeModel.NoticeData;
import com.example.skuniv.fleamarket2.viewModel.locationViewModel.ShopViewModel;

import retrofit2.Call;
import retrofit2.http.Body;
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
    Call<UserModel> getSignInRepos(@Body SignInJson signInJson);

    @POST("user/signup")
    Call<UserModel> getSignUpRepos(@Body SignUpJson signUpJson);

    @POST("user/findid")
    Call<UserModel> findIdRepos(@Body FindIdJson findIdJson);

    @POST("apply/one")
    Call<ResponseJson> applySendOneRepos(@Body ApplyOneJson applyOneJson);

    @GET("apply/select/{list_num}")
    Call<ApplyData> getApplyRepos(@Path("list_num") int list_num);

    @GET("apply/random/{apply_count}/{list_num}")
    Call<ApplyData> randomApplyRepos(@Path("apply_count") int applyCount, @Path("list_num") int list_num);

    @GET("apply/firstcome/{apply_count}/{list_num}")
    Call<ApplyData> firstcomeApplyRepos(@Path("apply_count") int applyCount, @Path("list_num") int list_num);

    @GET("seller/select/{shop}")
    Call<ShopModel> getSellerGoodsRepos(@Path("shop") String  shop);
}