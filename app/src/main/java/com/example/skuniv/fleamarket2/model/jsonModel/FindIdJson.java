package com.example.skuniv.fleamarket2.model.jsonModel;

public class FindIdJson {
    String id;
    String email;

    public FindIdJson(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
