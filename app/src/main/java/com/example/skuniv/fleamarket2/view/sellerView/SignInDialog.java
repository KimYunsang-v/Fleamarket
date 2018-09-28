package com.example.skuniv.fleamarket2.view.sellerView;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.databinding.SignInBinding;
import com.example.skuniv.fleamarket2.model.AdminSellerModel.UserModel;
import com.example.skuniv.fleamarket2.model.jsonModel.SignInJson;
import com.example.skuniv.fleamarket2.viewModel.AdminSellerViewModel.MainCommand;

public class SignInDialog extends Dialog{
    SignInBinding signInBinding;
    Context context;
    UserModel sellerModel;
    MainCommand mainCommand;
    SignInDialog signInDialog;

    public SignInDialog(@NonNull Context context, MainCommand mainCommand) {
        super(context);
        this.context = context;
        this.mainCommand = mainCommand;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        signInBinding = (SignInBinding)
                DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.sign_in, null, false);
        setContentView(signInBinding.getRoot());

        mainCommand.setSignInBinding(signInBinding);
        signInDialog = this;
        mainCommand.setSignInDialog(signInDialog);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(this.getWindow().getAttributes());
        lp.width = 800;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        signInBinding.signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignInJson signInJson = new SignInJson(signInBinding.idText.getText().toString(),signInBinding.pwText.getText().toString());
                //로그인 통신
                mainCommand.signIn(signInJson);
                //mainCommand.signInTest();

            }
        });

        signInBinding.signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUpDialog signUpDialog = new SignUpDialog(context, mainCommand);
                signUpDialog.show();
                signInDialog.dismiss();
            }
        });

        signInBinding.findIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FindIdDialog findIdDialog = new FindIdDialog(context, mainCommand);
                findIdDialog.show();
                signInDialog.dismiss();
            }
        });
    }
}
