package com.example.skuniv.fleamarket2.viewmodel;

import android.databinding.ObservableArrayList;

public class SelectDialogItemsModel {
    public final ObservableArrayList<SelectDialogItemModel> items = new ObservableArrayList<>();

    public void setItems(){
        for(int i =0; i<10;i++){
            items.add(new SelectDialogItemModel(""+i,""+i));
        }
    }
}
