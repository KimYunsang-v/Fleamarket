package com.example.skuniv.fleamarket2.viewModel.AdminSellerViewModel;

import android.content.Context;
import android.util.Log;

import com.example.skuniv.fleamarket2.model.AdminSellerModel.UserModel;
import com.example.skuniv.fleamarket2.model.jsonModel.ResponseJson;
import com.example.skuniv.fleamarket2.model.jsonModel.SellerApplyJson;
import com.example.skuniv.fleamarket2.model.locatonModel.ShopModel;
import com.example.skuniv.fleamarket2.retrofit.NetRetrofit;
import com.example.skuniv.fleamarket2.view.sellerView.SellerGoodsList;
import com.example.skuniv.fleamarket2.view.sellerView.SellerGoodsUpdateDialog;
import com.example.skuniv.fleamarket2.viewModel.locationViewModel.ShopViewModel;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SellerCommand {
    Context context;
    UserModel userModel;
    ShopViewModel shopViewModel;
    ShopModel shopModel;
    SellerGoodsList sellerGoodsListView;
    Gson gson = new Gson();

    public SellerCommand(Context context, UserModel userModel, ShopViewModel shopViewModel, SellerGoodsList sellerGoodsListView) {
        this.context = context;
        this.userModel = userModel;
        this.shopViewModel = shopViewModel;
        this.sellerGoodsListView = sellerGoodsListView;
    }

    public SellerCommand(){

    }

    public void getShopModel() {
        Call<ShopModel> res = NetRetrofit.getInstance().getService().getSellerGoodsRepos(userModel.getShop());
        Log.i("getShopList", "" + res);
        res.enqueue(new Callback<ShopModel>() {
            @Override
            public void onResponse(Call<ShopModel> call, Response<ShopModel> response) {
                Log.i("Retrofit", response.toString());
                if (response.body() != null) {
                    shopModel = response.body();
                    Log.i("getShopList", "" + gson.toJson(response.body()));
                    shopViewModel.setShopViewModel(shopModel);
                }
            }
            @Override
            public void onFailure(Call<ShopModel> call, Throwable t) {
                Log.e("에러", t.getMessage());
            }
        });
    }

   public void addGoods(){

   }

   public void sellerApply(SellerApplyJson sellerApplyJson){
        if(sellerApplyJson != null) {
            Call<ResponseJson> res = NetRetrofit.getInstance().getService().sellerApplyRepos(sellerApplyJson);
            Log.i("getShopList", "" + res);
            res.enqueue(new Callback<ResponseJson>() {
                @Override
                public void onResponse(Call<ResponseJson> call, Response<ResponseJson> response) {
                    Log.i("Retrofit", response.toString());
                    if (response.body() != null) {
                        ResponseJson responseJson = response.body();
                        Log.i("getShopList", "" + gson.toJson(response.body()));
                        if(responseJson.getResponse().equals("success")) {
                            Log.i("sellerApply result", "success");
                        }
                        else{
                            Log.i("sellerApply result", "fail");
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseJson> call, Throwable t) {
                    Log.e("에러", t.getMessage());
                }
            });
        }
   }
}

