package com.example.skuniv.fleamarket2.model.categoryModel;

import java.util.List;

public class CategoryData {
    List<CategoryShopModel> items;
    CategoryMeta meta;

    public List<CategoryShopModel> getItems() {
        return items;
    }

    public void setItems(List<CategoryShopModel> items) {
        this.items = items;
    }

    public CategoryMeta getMeta() {
        return meta;
    }

    public void setMeta(CategoryMeta meta) {
        this.meta = meta;
    }
}
