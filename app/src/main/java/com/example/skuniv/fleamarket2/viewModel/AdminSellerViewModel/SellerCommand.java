package com.example.skuniv.fleamarket2.viewModel.AdminSellerViewModel;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.example.skuniv.fleamarket2.model.AdminSellerModel.UserModel;
import com.example.skuniv.fleamarket2.model.jsonModel.ResponseJson;
import com.example.skuniv.fleamarket2.model.jsonModel.SellerApplyJson;
import com.example.skuniv.fleamarket2.model.locatonModel.Goods;
import com.example.skuniv.fleamarket2.model.locatonModel.ShopModel;
import com.example.skuniv.fleamarket2.retrofit.FileUtils;
import com.example.skuniv.fleamarket2.retrofit.NetRetrofit;
import com.example.skuniv.fleamarket2.view.sellerView.SellerGoodsList;
import com.example.skuniv.fleamarket2.view.sellerView.SellerGoodsUpdateDialog;
import com.example.skuniv.fleamarket2.viewModel.locationViewModel.ShopViewModel;
import com.google.gson.Gson;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SellerCommand extends SellerGoodsList {
    Context context;
    UserModel userModel;
    ShopViewModel shopViewModel;
    ShopModel shopModel;
    SellerGoodsList sellerGoodsListView;
    Gson gson = new Gson();
    SellerGoodsUpdateDialog sellerGoodsUpdateDialog;

    public void setSellerGoodsUpdateDialog(SellerGoodsUpdateDialog sellerGoodsUpdateDialog) {
        this.sellerGoodsUpdateDialog = sellerGoodsUpdateDialog;
    }

    public SellerCommand(Context context, UserModel userModel, ShopViewModel shopViewModel, SellerGoodsList sellerGoodsListView) {
        this.context = context;
        this.userModel = userModel;
        this.shopViewModel = shopViewModel;
        this.sellerGoodsListView = sellerGoodsListView;
    }

    public SellerCommand(){

    }

    public void getShopModel() {
        if(userModel != null) {
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
    }

   public void addGoods(final ShopViewModel shopViewModel, Goods goods, Uri fileUri){
       //File file = new File(fileUri.getPath());
       File file = FileUtils.getFile(context,fileUri);
       /*System.out.println("file ==" + file.getName());
       System.out.println("goods json ======" + gson.toJson(goods));*/
       RequestBody requestFile =
               RequestBody.create(MediaType.parse(context.getContentResolver().getType(fileUri)),file );

       // MultipartBody.Part is used to send also the actual file name
       MultipartBody.Part body =
               MultipartBody.Part.createFormData("image", file.getName(), requestFile);

       //RequestBody location = RequestBody.create( MultipartBody.FORM, shopViewModel.location.get());
       RequestBody location = RequestBody.create( MultipartBody.FORM, "b");
       //RequestBody shop = RequestBody.create( okhttp3.MultipartBody.FORM, shopViewModel.shop.get());
       RequestBody shop = RequestBody.create( okhttp3.MultipartBody.FORM, "B01");
       RequestBody name = RequestBody.create( okhttp3.MultipartBody.FORM, goods.getName());
       RequestBody price = RequestBody.create( okhttp3.MultipartBody.FORM, String.valueOf(goods.getPrice()));
       RequestBody quantity = RequestBody.create( okhttp3.MultipartBody.FORM, String.valueOf(goods.getQuantity()));
       RequestBody category = RequestBody.create( okhttp3.MultipartBody.FORM, gson.toJson(goods.getCategory()));

       if(shopViewModel != null) {
           Call<ResponseJson> res = NetRetrofit.getInstance().getService().sellerinsertGoodsRepos(body, location,
                   shop,name ,price ,quantity , category);
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
                           sellerGoodsUpdateDialog.cancel();
                           shopViewModel.goods.clear();
                           getShopModel();
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

