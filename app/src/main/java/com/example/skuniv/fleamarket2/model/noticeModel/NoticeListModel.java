package com.example.skuniv.fleamarket2.model.noticeModel;

import java.util.ArrayList;
import java.util.List;

public class NoticeListModel {
    public int page;

    public NoticeListModel(int page) {
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
