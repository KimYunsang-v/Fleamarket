package com.example.skuniv.fleamarket2.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ShopModel {
    @SerializedName("no")
    int no;
    @SerializedName("location")
    String location;
    @SerializedName("shop")
    String shop;
    @SerializedName("goods")
    ArrayList<Goods> goods;

    public ShopModel(int no, String location, String shop, ArrayList<Goods> goods){
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

    public ArrayList<Goods> getGoods() {
        return goods;
    }

    public void setGoods(ArrayList<Goods> goods) {
        this.goods = goods;
    }
}
