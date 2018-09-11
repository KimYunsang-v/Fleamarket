package com.example.skuniv.fleamarket2.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ShopData {
    List<ShopModel> shops;

    public List<ShopModel> getShops() {
        return shops;
    }

    public void setShops(List<ShopModel> shops) {
        this.shops = shops;
    }
}
