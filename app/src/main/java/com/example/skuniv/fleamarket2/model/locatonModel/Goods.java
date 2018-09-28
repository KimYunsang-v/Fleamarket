package com.example.skuniv.fleamarket2.model.locatonModel;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Goods {

    @SerializedName("name")
    String name;
    @SerializedName("price")
    int price;
    @SerializedName("quantity")
    int quantity;
    @SerializedName("category")
    ArrayList<Integer> category;
    @SerializedName("image")
    String image;

    public Goods(String name,int price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Goods(String name,int price, int quantity, ArrayList<Integer> category, String image){
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

    public List<Integer> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<Integer> category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
