package com.example.skuniv.fleamarket2.model.locatonModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShopData {
    @SerializedName("items")
    List<ShopModel> items;
    @SerializedName("meta")
    LocationMeta meta;

    public LocationMeta getMeta() {
        return meta;
    }

    public void meta(LocationMeta meta) {
        this.meta = meta;
    }

    public List<ShopModel> getShops() {
        return items;
    }

    public void setShops(List<ShopModel> items) {
        this.items = items;
    }
}
