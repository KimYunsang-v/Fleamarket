package com.example.skuniv.fleamarket2.model.noticeModel;

import java.util.ArrayList;
import java.util.List;

public class NoticeListModel {
    public static ArrayList<NoticeModel> noticeList = new ArrayList<>();
    public static int page;

    public NoticeListModel(int page){
        this.page = page;
    }

    public static ArrayList<NoticeModel> getNoticeList() {
        return noticeList;
    }

    public static void setNoticeList(ArrayList<NoticeModel> noticeList) {
        NoticeListModel.noticeList = noticeList;
    }

    public static int getPage() {
        return page;
    }
}
