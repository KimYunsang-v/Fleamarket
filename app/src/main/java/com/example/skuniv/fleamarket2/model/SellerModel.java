package com.example.skuniv.fleamarket2.model;

import com.google.gson.annotations.SerializedName;

public class SellerModel {
    @SerializedName("id")
    String id="";
    @SerializedName("shop")
    String shop ="";
    @SerializedName("role")
    int role=-1;
    @SerializedName("response")
    String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
