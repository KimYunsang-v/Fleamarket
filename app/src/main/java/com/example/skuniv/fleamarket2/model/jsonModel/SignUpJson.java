package com.example.skuniv.fleamarket2.model.jsonModel;

public class SignUpJson {
    String id;
    String pw;
    String name;
    String sex;
    String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SignUpJson(String id, String pw, String name, String sex, String email) {

        this.id = id;
        this.pw = pw;
        this.name = name;
        this.sex = sex;
        this.email = email;
    }
}
