package com.example.skuniv.fleamarket2;

import android.app.Activity;

import com.example.skuniv.fleamarket2.databinding.ShopItemBinding;
import com.example.skuniv.fleamarket2.model.Goods;

import java.util.ArrayList;

public class Myhandler {
    private Activity activity;
    ArrayList<Goods> goodsArrayList;
    ShopItemBinding binding;

    public Myhandler(Activity activity, ShopItemBinding binding) {
        this.activity = activity;
        this.binding = binding;
    }


}
