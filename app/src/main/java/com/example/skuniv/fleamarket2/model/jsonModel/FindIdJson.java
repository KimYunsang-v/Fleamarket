package com.example.skuniv.fleamarket2.model.jsonModel;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindIdJson {
    private String id;

import com.google.gson.annotations.SerializedName;

public class FindIdJson {
    @SerializedName("name")
    String name;
    @SerializedName("email")
    String email;


    
