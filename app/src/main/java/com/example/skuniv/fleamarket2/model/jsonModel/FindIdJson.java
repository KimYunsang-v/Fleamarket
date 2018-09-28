package com.example.skuniv.fleamarket2.model.jsonModel;

import com.google.gson.annotations.SerializedName;

public class FindIdJson {
    @SerializedName("name")
    String name;
    @SerializedName("email")
    String email;

    public FindIdJson(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {

        return name;
    }

    public void setId(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
