package com.example.skuniv.fleamarket2.model.categoryModel;

import com.example.skuniv.fleamarket2.model.locatonModel.Goods;
import com.google.gson.annotations.SerializedName;

public class CategoryShopModel{
    @SerializedName("no")
    int no;
    @SerializedName("location")
    String location;
    @SerializedName("shop")
    String shop;
    @SerializedName("good")
    Goods goods;

    public CategoryShopModel(int no, String location, String shop, Goods goods){
        this.no = no;
        this.location = location;
        this.shop = shop;
        this.goods = goods;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }


}
