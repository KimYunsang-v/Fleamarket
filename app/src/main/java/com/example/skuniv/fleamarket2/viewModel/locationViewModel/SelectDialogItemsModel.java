package com.example.skuniv.fleamarket2.viewModel.locationViewModel;

import android.databinding.ObservableArrayList;

public class SelectDialogItemsModel {
    public final ObservableArrayList<SelectDialogItemModel> items = new ObservableArrayList<>();

    public void setItems(){
        for(int i =0; i<120;i += 10){
            items.add(new SelectDialogItemModel(""+i,""+(i+9)));
        }
    }
}
