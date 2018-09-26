package com.example.skuniv.fleamarket2.model.AdminSellerModel;

import java.util.List;

public class ApplyData {
    List<ApplyModel> items;
    ApplyMeta meta;

    public List<ApplyModel> getItems() {
        return items;
    }

    public void setItems(List<ApplyModel> items) {
        this.items = items;
    }

    public ApplyMeta getMeta() {
        return meta;
    }

    public void setMeta(ApplyMeta meta) {
        this.meta = meta;
    }
}
