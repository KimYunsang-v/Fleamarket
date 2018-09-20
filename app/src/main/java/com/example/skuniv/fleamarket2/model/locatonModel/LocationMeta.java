package com.example.skuniv.fleamarket2.model.locatonModel;

import com.google.gson.annotations.SerializedName;

public class LocationMeta {
    @SerializedName("count")
    int shopCount;

    public int getShopCount() {
        return shopCount;
    }

    public void setShopCount(int shopCount) {
        this.shopCount = shopCount;
    }
}
