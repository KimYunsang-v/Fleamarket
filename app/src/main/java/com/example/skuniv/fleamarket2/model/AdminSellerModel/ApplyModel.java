package com.example.skuniv.fleamarket2.model.AdminSellerModel;

import com.google.gson.annotations.SerializedName;

public class ApplyModel {
    @SerializedName("id")
    String id="";
    @SerializedName("name")
    String name="";
    @SerializedName("title")
    String title="";
    @SerializedName("contents")
    String contents="";
    @SerializedName("role")
    int role=-1;
    @SerializedName("date")
    String date="";


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
