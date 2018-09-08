package com.example.skuniv.fleamarket2.view;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.ListView;

import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.adapter.ShopListAdapter;
import com.example.skuniv.fleamarket2.databinding.ActivitySectionBinding;
import com.example.skuniv.fleamarket2.databinding.ShopSelectDialogBinding;
import com.example.skuniv.fleamarket2.model.SectionModel;
import com.example.skuniv.fleamarket2.viewmodel.SectionCommand;
import com.example.skuniv.fleamarket2.viewmodel.ShopViewModel;
import com.example.skuniv.fleamarket2.viewmodel.ShopsViewModel;

public class SectionActivity extends AppCompatActivity {
    ShopsViewModel shopsViewModel = new ShopsViewModel();

    private ShopSelectDialogBinding dialogBinding;
    private ShopSelectDialog dialog;
    SectionCommand sectionCommand;

    ActivitySectionBinding sectionBinding;
    SectionModel sectionModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // activity_section과 databiding할 객체 생성
        sectionBinding = DataBindingUtil.setContentView(this, R.layout.activity_section);

        // section model객체 생성
        // 나중에 각 세션별로 값 다르게 넣어야 함
        sectionModel = new SectionModel("a",1);

        //sectionCommand 객체 생성
        sectionCommand = new SectionCommand(sectionModel, sectionBinding);

        shopsViewModel.setShops();
        // activity_section의 sectionModel 변수에 sectionModel 넣음
        sectionBinding.setSectionModel(sectionModel);

        // activity_section의 ShopModel 변수에 shopsViewModel 넣음
        sectionBinding.setShopModel(shopsViewModel);

        //select diaolg 띄우기
        sectionBinding.selectId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new ShopSelectDialog(SectionActivity.this,sectionModel);
                dialog.show();

                //디스플레이의 해상도를 가져옴
                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);

                //비율에 맞게 다이얼로그 크기를 지정
                Window window = dialog.getWindow();

                int x = (int)(size.x * 0.8f);
                int y = (int)(size.y * 0.9f);

                window.setLayout(x,y);
            }
        });

        sectionCommand.getShopList();
    }

    //listView adapter 생성
    @BindingAdapter("app:items")
    public static void setShopList(ListView listView, ObservableArrayList<ShopViewModel> shops){
        ShopListAdapter adapter;
        //adapter 없을 때 adapter 생성
        if(listView.getAdapter() == null){
            adapter = new ShopListAdapter();
            listView.setAdapter(adapter);
        }
        else {
            // 있으면 getAdapter
            adapter = (ShopListAdapter) listView.getAdapter();
        }
        adapter.addAll(shops);
    }
}
