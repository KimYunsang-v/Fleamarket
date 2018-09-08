package com.example.skuniv.fleamarket2.model;

import com.google.gson.annotations.SerializedName;

public class Goods {

    @SerializedName("name")
    String name;
    @SerializedName("price")
    int price;
    @SerializedName("quantity")
    int quantity;
    @SerializedName("category")
    String category;
    @SerializedName("image")
    String image;

    public Goods(String name,int price, int quantity, String category, String image){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
