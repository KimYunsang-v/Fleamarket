package com.example.skuniv.fleamarket2.model.AdminSellerModel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserModel implements Serializable{
    @SerializedName("id")
    String id="";
    @SerializedName("pw")
    String pw="";
    @SerializedName("sex")
    String sex="";
    @SerializedName("name")
    String name="";

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @SerializedName("email")

    String email="";
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
