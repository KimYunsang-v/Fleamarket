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
    private ShopMapBinding dialogBinding;
    String shop,shopNum;
    public ShopMapDialog(Context context, CategoryShopViewModel categoryShopViewModel) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.categoryShopViewModel = categoryShopViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //shop = categoryShopViewModel.shop.get();
        shop = "A02";
        String location = "a";
        shopNum = shop.split(location.toUpperCase())[1];
        System.out.println("shop num    "+shopNum);

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


        System.out.println("select shop map==="+view.getId());
    }
}