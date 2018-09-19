package com.example.skuniv.fleamarket2.view.categoryView;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.viewModel.categoryViewmodel.CategoryShopViewModel;
import com.example.skuniv.fleamarket2.viewModel.locationViewModel.SelectDialogItemsModel;
import com.example.skuniv.fleamarket2.databinding.ShopMapBinding;

public class ShopMapDialog extends Dialog {


    CategoryShopViewModel categoryShopViewModel;
    SelectDialogItemsModel selectDialogItemsModel;
    private ShopMapBinding dialogBinding;
    String section;
    Integer shopNum;
    Boolean[] setBack;

    public ShopMapDialog(Context context, CategoryShopViewModel categoryShopViewModel) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.categoryShopViewModel = categoryShopViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //selectDialogItemsModel = new SelectDialogItemsModel();

        //section = categoryShopViewModel.location.get();
        //shopNum = categoryShopViewModel.no.get();

        // 다이얼로그 외부 화면 흐리게 표현
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);

        dialogBinding = (ShopMapBinding)
                DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.shop_map, null, false);
        setContentView(dialogBinding.getRoot());

        dialogBinding.setMap(this);

        //DialogBinding.setSelect(shopNum);
        //setBack = new Boolean[120];
        //setBack[shopNum] = true;
        //dialogBinding.setShopList(setBack);
    }
    //@BindingAdapter({"bind:setColor"})
    public void setBackground(View view) {
        /*if(view.getText().equals(Integer.toString(select))){
            //view.setTextColor(Color.parseColor("#000000"));
        }
        else{

        }*/
        view.getId();
        System.out.println("select shop map==="+view.getId());
    }
}