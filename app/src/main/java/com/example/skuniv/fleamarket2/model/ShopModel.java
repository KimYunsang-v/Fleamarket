package com.example.skuniv.fleamarket2.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShopModel implements Serializable{
    @SerializedName("no")
    int no;
    @SerializedName("location")
    String location;
    @SerializedName("shop")
    String shop;
    @SerializedName("goods")
    List<Goods> goods;

    public ShopModel(int no, String location, String shop, List<Goods> goods){
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

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }
}