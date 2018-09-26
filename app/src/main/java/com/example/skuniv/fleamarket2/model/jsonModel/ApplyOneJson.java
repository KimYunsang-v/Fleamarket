package com.example.skuniv.fleamarket2.model.jsonModel;

public class ApplyOneJson {
    String id;
    int role;
    String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public ApplyOneJson(String id, int role) {
        this.id = id;
        this.role = role;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
