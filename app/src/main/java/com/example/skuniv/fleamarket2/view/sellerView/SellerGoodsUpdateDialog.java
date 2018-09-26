package com.example.skuniv.fleamarket2.view.sellerView;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.skuniv.fleamarket2.databinding.SellerGoodsUpdateDialogBinding;
import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.model.AdminSellerModel.UserModel;
import com.example.skuniv.fleamarket2.model.locatonModel.Goods;
import com.example.skuniv.fleamarket2.viewModel.locationViewModel.GoodsViewModel;
import com.example.skuniv.fleamarket2.viewModel.locationViewModel.ShopViewModel;

public class SellerGoodsUpdateDialog extends Dialog {
    SellerGoodsUpdateDialogBinding sellerGoodsUpdateDialogBinding;
    Context context;
    GoodsViewModel goodsViewModel;
    ShopViewModel shopViewModel;
    UserModel userModel;
    ArrayAdapter mainSpinner, middleSpinner;
    String[] mainC = {"cloth", "digital", "fancy", "acc", "book", "etc"};
    String mainCategory, middleCategory;

    public SellerGoodsUpdateDialog(@NonNull Context context, UserModel userModel, ShopViewModel shopViewModel) {
        super(context);
        this.context = context;
        this.userModel = userModel;
        this.shopViewModel = shopViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sellerGoodsUpdateDialogBinding = (SellerGoodsUpdateDialogBinding)
                DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.seller_goods_update_dialog, null, false);
        setContentView(sellerGoodsUpdateDialogBinding.getRoot());



        // 스피너 셋팅
        mainSpinner = new ArrayAdapter(
                context,android.R.layout.simple_spinner_item, mainC);

        mainSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sellerGoodsUpdateDialogBinding.mainSpinnerId.setAdapter(mainSpinner);

        sellerGoodsUpdateDialogBinding.mainSpinnerId.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mainCategory = adapterView.getItemAtPosition(i).toString();
                setMiddleSpinner();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {      }
        });

        sellerGoodsUpdateDialogBinding.middleSpinnerId.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                middleCategory = adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {      }
        });

        sellerGoodsUpdateDialogBinding.confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {   }
        });
    }

    private void setMiddleSpinner(){
        middleSpinner = new ArrayAdapter(
                context,android.R.layout.simple_spinner_item, getList(mainCategory));
        middleSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sellerGoodsUpdateDialogBinding.middleSpinnerId.setAdapter(middleSpinner);

    }

    private String[] getList(String mainCategory){
        if(mainCategory.equals("cloth")){
            return context.getResources().getStringArray(R.array.cloth);
        }else if(mainCategory.equals("digital")){
            return context.getResources().getStringArray(R.array.digital);
        }else if(mainCategory.equals("fancy")){
            return context.getResources().getStringArray(R.array.fancy);
        }else if(mainCategory.equals("acc")){
            return context.getResources().getStringArray(R.array.acc);
        }else if(mainCategory.equals("book")){
            return context.getResources().getStringArray(R.array.book);
        }else if(mainCategory.equals("etc")){
            return context.getResources().getStringArray(R.array.etc);
        }
        return null;
    }

    public void setGoodsViewModel(GoodsViewModel goodsViewModel) {
        this.goodsViewModel = goodsViewModel;
        sellerGoodsUpdateDialogBinding.nameText.setText(goodsViewModel.name.get());
        sellerGoodsUpdateDialogBinding.priceText.setText(""+goodsViewModel.price.get());
        sellerGoodsUpdateDialogBinding.quantityText.setText(""+goodsViewModel.quantity.get());
    }
}
