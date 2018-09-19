package com.example.skuniv.fleamarket2.view.noticeView;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.WindowManager;

import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.databinding.NoticeItemBinding;
import com.example.skuniv.fleamarket2.viewModel.noticeViewModel.NoticeItemViewModel;

import java.io.Serializable;

public class NoticeItemDialog extends Dialog{
    NoticeItemBinding noticeItemBinding;
    NoticeItemViewModel noticeItemViewModel;
    Context context;

    public NoticeItemDialog(Context context, NoticeItemViewModel noticeItemViewModel){
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.context = context;
        this.noticeItemViewModel = noticeItemViewModel;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noticeItemBinding = (NoticeItemBinding)
                DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.notice_item, null, false);
        setContentView(noticeItemBinding.getRoot());

        noticeItemBinding.setNotice(noticeItemViewModel);

        // 다이얼로그 외부 화면 흐리게 표현
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);
    }
}
