package com.example.skuniv.fleamarket2.view;

import android.app.Dialog;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.adapter.SelectItemListAdapter;
import com.example.skuniv.fleamarket2.adapter.ShopListAdapter;
import com.example.skuniv.fleamarket2.databinding.ShopSelectDialogBinding;
import com.example.skuniv.fleamarket2.model.SectionModel;
import com.example.skuniv.fleamarket2.viewmodel.SelectDialogItemModel;
import com.example.skuniv.fleamarket2.viewmodel.SelectDialogItemsModel;
import com.example.skuniv.fleamarket2.viewmodel.ShopViewModel;

public class ShopSelectDialog  extends Dialog{

    //private SectionModel sectionModel = new SectionModel();
    SectionModel sectionModel;
    SelectDialogItemsModel selectDialogItemsModel = new SelectDialogItemsModel();
    ShopSelectDialogBinding binding;

    public ShopSelectDialog(Context context,SectionModel sectionModel) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.sectionModel = sectionModel;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_select_dialog);

        //binding = DataBindingUtil.setContentView(,R.layout.shop_select_dialog);
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()),R.layout.shop_select_dialog, null, false);
        setContentView(binding.getRoot());

        // 다이얼로그 외부 화면 흐리게 표현
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);


    }

    //listView adapter 생성
    @BindingAdapter("app:items")
    public static void setSelectItemList(ListView listView, ObservableArrayList<SelectDialogItemModel> items){
        SelectItemListAdapter adapter;
        //adapter 없을 때 adapter 생성
        if(listView.getAdapter() == null){
            adapter = new SelectItemListAdapter();
            listView.setAdapter(adapter);
        }
        else {
            // 있으면 getAdapter
            adapter = (SelectItemListAdapter) listView.getAdapter();
        }

        adapter.addAll(items);
    }
}
