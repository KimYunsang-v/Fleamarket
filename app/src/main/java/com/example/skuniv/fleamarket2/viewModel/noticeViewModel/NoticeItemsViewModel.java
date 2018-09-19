package com.example.skuniv.fleamarket2.viewModel.noticeViewModel;

import android.databinding.ObservableArrayList;

import com.example.skuniv.fleamarket2.model.noticeModel.NoticeModel;
import com.example.skuniv.fleamarket2.viewModel.locationViewModel.SelectDialogItemModel;

import java.util.List;

public class NoticeItemsViewModel {
    public final ObservableArrayList<NoticeItemViewModel> noticeList = new ObservableArrayList<>();

    public void setNoticeList(List<NoticeModel> noticeList){
        for(int i =0; i<noticeList.size();i++){
            this.noticeList.add(new NoticeItemViewModel(noticeList.get(i).getNo(),noticeList.get(i).getTitle(),noticeList.get(i).getDate(),
                    noticeList.get(i).getContents(),noticeList.get(i).getFiles()));
        }
    }

    public ObservableArrayList<NoticeItemViewModel> getNoticeList() {
        return noticeList;
    }
}
