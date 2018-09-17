package com.example.skuniv.fleamarket2.viewModel.locationViewModel;

import android.databinding.ObservableArrayList;

import com.example.skuniv.fleamarket2.model.locatonModel.Goods;

import java.util.List;

public class GoodsListViewModel {
    public final ObservableArrayList<GoodsViewModel> goodsList = new ObservableArrayList<>();

    public void setGoodsList(List<Goods> goods){
        for(int i =0; i<goodsList.size() ;i++){
            goodsList.add(new GoodsViewModel(goods.get(i).getName(),goods.get(i).getPrice(),goods.get(i).getQuantity(),goods.get(i).getCategory(),goods.get(i).getImage()));
        }
    }

    public ObservableArrayList<GoodsViewModel> getGoodsList() {
        return goodsList;
    }
}