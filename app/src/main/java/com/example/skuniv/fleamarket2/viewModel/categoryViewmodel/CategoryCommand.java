package com.example.skuniv.fleamarket2.viewModel.categoryViewmodel;

import android.content.Context;
import android.util.Log;

import com.example.skuniv.fleamarket2.retrofit.NetRetrofit;
import com.example.skuniv.fleamarket2.adapter.CategoryListAdapter;
import com.example.skuniv.fleamarket2.databinding.ActivityCategoryListBinding;
import com.example.skuniv.fleamarket2.databinding.CategoryItemBinding;
import com.example.skuniv.fleamarket2.model.categoryModel.CategoryModel;
import com.example.skuniv.fleamarket2.model.categoryModel.CategoryShopModel;
import com.example.skuniv.fleamarket2.view.locationView.ShopMapDialog;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryCommand {

    Context context;
    ActivityCategoryListBinding categoryListBinding;
    CategoryModel categoryModel;

    List<CategoryShopModel> categoryShopList;
    CategoryShopsViewModel categoryShopsViewModel;
    Gson gson = new Gson();
    CategoryItemBinding categoryItemBinding;
    ShopMapDialog dialog;
    CategoryListAdapter mAdapter;
    CategoryCommand categoryCommand;


    public CategoryCommand(Context context, ActivityCategoryListBinding categoryListBinding, CategoryModel categoryModel, CategoryShopsViewModel categoryShopsViewModel){
        this.context = context;
        this.categoryListBinding = categoryListBinding;
        this.categoryModel = categoryModel;
        this.categoryShopsViewModel = categoryShopsViewModel;
        categoryCommand = this;

    }

    public void getGoodsList(){
        if (!(categoryModel.getCategoty().isEmpty()) && categoryModel.getPageNum() >= 0) {
            Call<List<CategoryShopModel>> res = NetRetrofit.getInstance().getService().getGoodsRepos(categoryModel.getCategoty(),categoryModel.getPageNum());
            Log.i("getGoodsList",""+res);
            res.enqueue(new Callback<List<CategoryShopModel>>() {
                @Override
                public void onResponse(Call<List<CategoryShopModel>> call, Response<List<CategoryShopModel>> response) {
                    Log.i("Retrofit", response.toString());
                    if (response.body() != null) {
                        categoryShopList = response.body();
                        Log.i("getShopList",""+gson.toJson(categoryShopList));
                        categoryShopsViewModel.setCategoryShopsViewModel(categoryShopList);
                        System.out.println(categoryShopsViewModel);
                        mAdapter = new CategoryListAdapter(categoryShopsViewModel.getShops(), context,categoryCommand);
                        System.out.println(categoryShopsViewModel.getShops());


                        categoryListBinding.recyclerId2.setAdapter(mAdapter);
                        //getAdapter();
                    }
                }
                @Override
                public void onFailure(Call<List<CategoryShopModel>> call, Throwable t) {
                    Log.e("에러", t.getMessage());
                }
            });
        } else {
            Log.e("getShopList","getShopList error");
        }
    }

    public void mapClickListener(CategoryShopViewModel shop){
        dialog = new ShopMapDialog(context,shop);
        System.out.println("--=---------mapmap");
        dialog.show();
    }





}
