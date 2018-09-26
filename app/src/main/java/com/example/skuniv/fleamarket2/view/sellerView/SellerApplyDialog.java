package com.example.skuniv.fleamarket2.view.sellerView;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;

import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.databinding.SellerApplyBinding;
import com.example.skuniv.fleamarket2.model.AdminSellerModel.UserModel;

public class SellerApplyDialog extends Dialog{
    UserModel userModel;
    SellerApplyBinding sellerApplyBinding;
    public SellerApplyDialog(@NonNull Context context, UserModel userModel) {
        super(context);
        this.userModel = userModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sellerApplyBinding = (SellerApplyBinding)
                DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.seller_apply, null, false);
        setContentView(sellerApplyBinding.getRoot());

        sellerApplyBinding.idId.setText(userModel.getId());
        sellerApplyBinding.nameId.setText(userModel.getName());


    }
}
