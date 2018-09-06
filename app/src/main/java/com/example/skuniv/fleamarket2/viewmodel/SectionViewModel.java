package com.example.skuniv.fleamarket2.viewmodel;

import android.view.View;

import com.example.skuniv.fleamarket2.model.SectionModel;
import com.example.skuniv.fleamarket2.view.ShopSelectDialog;

public class SectionViewModel {

    SectionModel sectionModel;
    ShopSelectDialog shopSelectDialog;

    public SectionViewModel(SectionModel sectionModel){
        this.sectionModel = sectionModel;
    }

    public void selectDialog(View view){
        //shopSelectDialog = new ShopSelectDialog();
        shopSelectDialog.show();
    }


}
