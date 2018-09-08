package com.example.skuniv.fleamarket2.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ShopData {
    ArrayList<ShopModel> shops;

    public ArrayList<ShopModel> getShops() {
        return shops;
    }

    public void setShops(ArrayList<ShopModel> shops) {
        this.shops = shops;
    }
}
