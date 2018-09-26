package com.example.skuniv.fleamarket2.model.jsonModel;

import com.google.gson.annotations.SerializedName;

public class ResponseJson {


    @SerializedName("response")
    String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
