package com.example.skuniv.fleamarket2.viewmodel;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.databinding.ShopSelectDialogBinding;
import com.example.skuniv.fleamarket2.model.SectionModel;
import com.example.skuniv.fleamarket2.view.ShopSelectDialog;

public class SectionViewModel {

    SectionModel sectionModel;

    private Context context;
    private ShopSelectDialogBinding dialogBinding;
    private ShopSelectDialog dialog;
    ShopSelectDialog shopSelectDialog;



    public SectionViewModel(Context context, SectionModel sectionModel){
        this.context = context;
        this.sectionModel = sectionModel;

    }

    public void selectDialog(View view){
        //shopSelectDialog = new ShopSelectDialog();
        shopSelectDialog.show();
    }





}
