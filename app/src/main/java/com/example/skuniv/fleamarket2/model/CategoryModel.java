package com.example.skuniv.fleamarket2.model;

public class CategoryModel {

    public String category;
    public int pageNum;

    public CategoryModel(String category, int pageNum){
        this.category = category;
        this.pageNum = pageNum;
    }

    public String getCategoty() {
        return category;
    }

    public void setCategoty(String categoty) {
        this.category = categoty;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
