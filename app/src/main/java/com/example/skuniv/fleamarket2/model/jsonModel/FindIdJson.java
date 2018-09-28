package com.example.skuniv.fleamarket2.model.jsonModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindIdJson {
    private String id;
    private String email;

    public FindIdJson(String id, String email) {
        this.id = id;
        this.email = email;
    }
}
