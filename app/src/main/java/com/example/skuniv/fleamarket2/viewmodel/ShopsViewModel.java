package com.example.skuniv.fleamarket2.viewmodel;

import android.databinding.ObservableArrayList;

public class ShopsViewModel{
    public final ObservableArrayList<ShopViewModel> shops = new ObservableArrayList<>();

    public void setShops(){
        for(int i =0; i<10;i++){
            shops.add(new ShopViewModel(""+i,""+i));
        }
    }
}
