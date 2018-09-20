package com.example.skuniv.fleamarket2.view.noticeView;

import android.Manifest;
import android.app.Dialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.pm.ActivityInfoCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.databinding.NoticeItemBinding;
import com.example.skuniv.fleamarket2.viewModel.noticeViewModel.NoticeCommand;
import com.example.skuniv.fleamarket2.viewModel.noticeViewModel.NoticeItemViewModel;

import java.io.File;
import java.io.Serializable;

public class NoticeItemDialog extends Dialog{
    NoticeItemBinding noticeItemBinding;
    NoticeItemViewModel noticeItemViewModel;
    Context context;
    NoticeCommand noticeCommand;

    static final int PERMISSION_REQUEST_CODE = 1;
    String[] PERMISSIONS = {"android.permission.READ_EXTERNAL_STORAGE","android.permission.WRITE_EXTERNAL_STORAGE"};

    public NoticeItemDialog(Context context, NoticeItemViewModel noticeItemViewModel, NoticeCommand noticeCommand){
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.context = context;
        this.noticeItemViewModel = noticeItemViewModel;
        this.noticeCommand = noticeCommand;
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

        noticeItemBinding.downId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noticeCommand.downlaodFile("http://13.125.128.130/static/bazaar_img/e/1-1.jpg");
            }
        });
    }
}
