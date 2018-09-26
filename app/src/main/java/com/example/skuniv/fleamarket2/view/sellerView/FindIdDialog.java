package com.example.skuniv.fleamarket2.view.sellerView;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.databinding.FindIdBinding;
import com.example.skuniv.fleamarket2.model.jsonModel.FindIdJson;
import com.example.skuniv.fleamarket2.viewModel.AdminSellerViewModel.MainCommand;

public class FindIdDialog extends Dialog {
    MainCommand mainCommand;
    Context context;
    FindIdBinding findIdBinding;

    public FindIdDialog(@NonNull Context context, MainCommand mainCommand) {
        super(context);
        this.context = context;
        this.mainCommand = mainCommand;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        findIdBinding = (FindIdBinding)
                DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.find_id, null, false);
        setContentView(findIdBinding.getRoot());

        mainCommand.setFindIdBinding(findIdBinding);
        mainCommand.setFindIdDialog(this);

        findIdBinding.findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FindIdJson findIdJson = new FindIdJson(findIdBinding.nameId.getText().toString(), findIdBinding.emailId.getText().toString());
                mainCommand.findId(findIdJson);
                //mainCommand.findIdTest();
            }
        });
    }
}
