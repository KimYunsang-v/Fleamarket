package com.example.skuniv.fleamarket2.viewmodel;

import android.databinding.ObservableArrayList;

import com.example.skuniv.fleamarket2.model.ShopModel;

import java.util.ArrayList;
import java.util.List;

public class ShopsViewModel{
    public final ObservableArrayList<ShopViewModel> shops = new ObservableArrayList<>();

    public void setShops(List<ShopModel> shopModels){
        for(int i =0; i<shopModels.size() ;i++){
            //shops.add(new ShopViewModel(shopModels.get(i).getNo(),shopModels.get(i).getLocation(),shopModels.get(i).getShop()));
            shops.add(new ShopViewModel(shopModels.get(i)));
        }
    }


}
