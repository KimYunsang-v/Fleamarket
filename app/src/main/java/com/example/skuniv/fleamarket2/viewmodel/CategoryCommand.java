package com.example.skuniv.fleamarket2.viewmodel;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.skuniv.fleamarket2.NetRetrofit;
import com.example.skuniv.fleamarket2.adapter.GoodsListAdapter;
import com.example.skuniv.fleamarket2.databinding.ActivityCategoryListBinding;
import com.example.skuniv.fleamarket2.model.CategoryModel;
import com.example.skuniv.fleamarket2.model.Goods;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryCommand {

    Context context;
    ActivityCategoryListBinding categoryListBinding;
    CategoryModel categoryModel;
    GoodsListAdapter mAdapter;
    List<Goods> goodsList;
    GoodsListViewModel goodsListViewModel;
    Gson gson = new Gson();


    public CategoryCommand(Context context, ActivityCategoryListBinding categoryListBinding, CategoryModel categoryModel, GoodsListViewModel goodsListViewModel){
        this.context = context;
        this.categoryListBinding = categoryListBinding;
        this.categoryModel = categoryModel;
        this.goodsListViewModel = goodsListViewModel;
    }

    public void getGoodsList(){
        if (!(categoryModel.getCategoty().isEmpty()) && categoryModel.getPageNum() >= 0) {
            Call<List<Goods>> res = NetRetrofit.getInstance().getService().getGoodsRepos(categoryModel.getCategoty(),categoryModel.getPageNum());
            Log.i("getGoodsList",""+res);
            res.enqueue(new Callback<List<Goods>>() {
                @Override
                public void onResponse(Call<List<Goods>> call, Response<List<Goods>> response) {
                    Log.i("Retrofit", response.toString());
                    if (response.body() != null) {
                        goodsList = response.body();
                        Log.i("getShopList",""+gson.toJson(response.body()));
                        goodsListViewModel.setGoodsList(goodsList);
                    }
                }
                @Override
                public void onFailure(Call<List<Goods>> call, Throwable t) {
                    Log.e("에러", t.getMessage());
                }
            });
        } else {
            Log.e("getShopList","getShopList error");
        }
    }

    public void getAdapter(){
        // 레이아웃 매니져, 어댑터 생성 후 recycler에 set 함
        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        mAdapter = new GoodsListAdapter(goodsListViewModel.getGoodsList(), context);

        categoryListBinding.recyclerId2.setLayoutManager(llm);
        categoryListBinding.recyclerId2.setAdapter(mAdapter);
        categoryListBinding.setGoodsL(goodsListViewModel.getGoodsList());
    }





}
