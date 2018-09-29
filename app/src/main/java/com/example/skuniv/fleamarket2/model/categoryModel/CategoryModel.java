package com.example.skuniv.fleamarket2.model.categoryModel;

import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.model.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CategoryModel {

    public ArrayList<Integer> categoryList = new ArrayList<>();
    public int pageNum;
    public String categoryStr;
    Category category;

    public CategoryModel(String categoryStr, int pageNum){
        category = new Category();
        this.categoryStr = categoryStr.toUpperCase();
        this.categoryList.add(category.getCategoryNum(categoryStr));
        this.pageNum = pageNum;
        /*if(category.equals("cloth")){
            middleCategory = TOP;
        }else if(category.equals("digital")){
            middleCategory = PC;
        }else if(category.equals("fancy")){
            middleCategory = NOTE;
        }else if(category.equals("acc")){
            middleCategory = RING;
        }else if(category.equals("book")){
            middleCategory = NOVEL;
        }else if(category.equals("etc")){
            middleCategory = PERFUME;
        }*/
    }

    public void addCategory(String categoryStr){
        if(categoryList.size() >= 2) {
            categoryList.remove(1);
            categoryList.add(category.getCategoryNum(categoryStr));
            //this.categoryStr += ">" + categoryStr;
        } else {
            categoryList.add(category.getCategoryNum(categoryStr));
        }
        System.out.println("categoryStr=====" + categoryStr);
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int categoryLastValue(){
        int lastIndex = categoryList.size() - 1;
        return categoryList.get(lastIndex);
    }
}