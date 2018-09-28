package com.example.skuniv.fleamarket2.view.adminView;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.databinding.ApplyDialogBinding;
import com.example.skuniv.fleamarket2.viewModel.AdminSellerViewModel.AdminCommand;
import com.example.skuniv.fleamarket2.viewModel.AdminSellerViewModel.ApplyItemViewModel;

public class ApplyDialog extends Dialog{
    ApplyDialogBinding applyDialogBinding;
    public ApplyItemViewModel applyItemViewModel;
    AdminCommand adminComman;
    Context context;
    ApplyDialog applyDialog;

    public ApplyDialog(@NonNull Context context, ApplyItemViewModel applyItemViewModel, AdminCommand adminCommand) {
        super(context);
        this.context = context;
        this.applyItemViewModel = applyItemViewModel;
        this.adminComman = adminCommand;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        applyDialogBinding = (ApplyDialogBinding)
                DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.apply_dialog, null, false);
        setContentView(applyDialogBinding.getRoot());

        applyDialogBinding.setApply(applyItemViewModel);

        applyDialog = this;


        applyDialogBinding.admissionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adminComman.applySendOne(applyItemViewModel.id.get(),2);
                applyDialog.cancel();
            }
        });

        applyDialogBinding.refuseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adminComman.applySendOne(applyItemViewModel.id.get(),3);
                applyDialog.cancel();
            }
        });
    }
}