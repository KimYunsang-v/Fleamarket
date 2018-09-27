package com.example.skuniv.fleamarket2.view.sellerView;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.skuniv.fleamarket2.databinding.SellerGoodsUpdateDialogBinding;
import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.model.AdminSellerModel.UserModel;
import com.example.skuniv.fleamarket2.model.Category;
import com.example.skuniv.fleamarket2.model.locatonModel.Goods;
import com.example.skuniv.fleamarket2.viewModel.AdminSellerViewModel.SellerCommand;
import com.example.skuniv.fleamarket2.viewModel.locationViewModel.GoodsViewModel;
import com.example.skuniv.fleamarket2.viewModel.locationViewModel.ShopViewModel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class SellerGoodsUpdateDialog extends Dialog {
    SellerGoodsUpdateDialogBinding sellerGoodsUpdateDialogBinding;
    Context context;
    GoodsViewModel goodsViewModel;
    ShopViewModel shopViewModel;
    UserModel userModel;
    ArrayAdapter mainSpinner, middleSpinner;
    String[] mainC = {"cloth", "digital", "fancy", "acc", "book", "etc"};
    String mainCategory, middleCategory;
    SellerGoodsList sellerGoodsListView;
    SellerCommand sellerCommand;
    Category category;
    Uri fileUri;

    public SellerGoodsUpdateDialog(@NonNull Context context, UserModel userModel, ShopViewModel shopViewModel,
                                   SellerGoodsList sellerGoodsListView, SellerCommand sellerCommand) {
        super(context);
        this.context = context;
        this.userModel = userModel;
        this.shopViewModel = shopViewModel;
        this.sellerGoodsListView = sellerGoodsListView;
        this.sellerCommand = sellerCommand;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sellerGoodsUpdateDialogBinding = (SellerGoodsUpdateDialogBinding)
                DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.seller_goods_update_dialog, null, false);
        setContentView(sellerGoodsUpdateDialogBinding.getRoot());
        sellerCommand.setSellerGoodsUpdateDialog(this);
        category = new Category();
        //getImage = new GetImage();
        //getImage.setSellerGoodsUpdateDialogBinding(sellerGoodsUpdateDialogBinding);

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
            public void onClick(View view) {
                Goods goods = new Goods(sellerGoodsUpdateDialogBinding.nameText.getText().toString(), Integer.valueOf(sellerGoodsUpdateDialogBinding.priceText.getText().toString()),
                        Integer.valueOf(sellerGoodsUpdateDialogBinding.quantityText.getText().toString()));
                ArrayList<Integer> categoryList = new ArrayList<Integer>();
                categoryList.add(category.getCategoryNum(mainCategory));
                categoryList.add(category.getCategoryNum(middleCategory));
                goods.setCategory(categoryList);;
                fileUri = sellerGoodsListView.getImageUri();
                System.out.println("file uri path ======" + fileUri.getPath());
                sellerCommand.addGoods(shopViewModel,goods,fileUri);
            }
        });

        sellerGoodsUpdateDialogBinding.imageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sellerGoodsListView.getImage();
            }
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
