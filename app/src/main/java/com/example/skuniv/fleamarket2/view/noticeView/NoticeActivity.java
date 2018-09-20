package com.example.skuniv.fleamarket2.view.noticeView;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.adapter.CategoryListAdapter;
import com.example.skuniv.fleamarket2.adapter.NoticeListAdapter;
import com.example.skuniv.fleamarket2.databinding.ActivityNoticeBinding;
import com.example.skuniv.fleamarket2.model.noticeModel.NoticeListModel;
import com.example.skuniv.fleamarket2.viewModel.categoryViewmodel.CategoryShopViewModel;
import com.example.skuniv.fleamarket2.viewModel.noticeViewModel.NoticeCommand;
import com.example.skuniv.fleamarket2.viewModel.noticeViewModel.NoticeItemViewModel;
import com.example.skuniv.fleamarket2.viewModel.noticeViewModel.NoticeItemsViewModel;

public class NoticeActivity extends AppCompatActivity implements NoticeListAdapter.OnLoadMoreListener{
    static ActivityNoticeBinding binding;
    static NoticeItemsViewModel noticeItemsViewModel;
    static NoticeListModel noticeListModel;
    static NoticeListAdapter adapter;
    static LinearLayoutManager llm;
    static Context context;
    static NoticeCommand noticeCommand;
    static NoticeListAdapter.OnLoadMoreListener onLoadMoreListener;
    private GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_notice);

        noticeListModel = new NoticeListModel(1);
        noticeItemsViewModel = new NoticeItemsViewModel();

        binding.setNoticeList(noticeItemsViewModel);

        context = this;

        noticeCommand = new NoticeCommand(context, binding, noticeListModel, noticeItemsViewModel);

        onLoadMoreListener = this;

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        binding.recyclerId3.setLayoutManager(llm);

        noticeCommand.jsonPaser(getJson(noticeListModel.getPage()));
    }

    @Override
    public void onLoadMore() {
        Log.d("NoticeActivity_", "onLoadMore");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                ///////이부분에을 자신의 프로젝트에 맞게 설정하면 됨
                //다음 페이지? 내용을 불러오는 부분
                //categoryCommand.scrollListener();
                NoticeListModel.page += 1;
                noticeCommand.jsonPaser(getJson(noticeListModel.getPage()));
                adapter.setMoreLoading(false);
                //////////////////////////////////////////////////
                //mAdapter.setMoreLoading(false);
            }
        }, 2000);
        /*categoryModel.setPageNum(categoryModel.getPageNum()+1);
        categoryCommand.jsonPaser(getJson(categoryModel.getPageNum()));
        adapter.setMoreLoading(false);*/
    }

    @BindingAdapter("app:items")
    public static void setNoticeList(RecyclerView recyclerView, ObservableArrayList<NoticeItemViewModel> shops){
        //adapter 없을 때 adapter 생성
        System.out.println("setShopList=============");
        if(recyclerView.getAdapter() == null){
            System.out.println("new categoryListAdapter");
            adapter = new NoticeListAdapter(noticeItemsViewModel.getNoticeList(),context,noticeCommand,onLoadMoreListener);
            adapter.setLinearLayoutManager(llm);
            recyclerView.setAdapter(adapter);
            adapter.setRecyclerView(binding.recyclerId3);
        }
        else {
            // 있으면 getAdapter
            adapter = (NoticeListAdapter) recyclerView.getAdapter();
            adapter.setNoiceList(noticeItemsViewModel.getNoticeList());
            System.out.println("get adapter");
        }
        //adapter.addAll(shops);
        //Log.i("adapter", shops.get(0).getGoods().get(0).getImage());
    }

    public String getJson(int page){
        String json="";
        if(page == 1){
            json = "[\n" +
                    "  {\n" +
                    "    \"no\": 1,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 2,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 3,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 4,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 5,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 6,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 7,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 8,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 9,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 10,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  }\n" +
                    "]";
        }
        else if(page == 2){
            json = "[\n" +
                    "  {\n" +
                    "    \"no\": 11,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 12,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 13,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 14,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 15,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 16,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 17,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 18,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 19,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 20,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  }\n" +
                    "]";
        }
        else if(page == 3){
            json = "[\n" +
                    "  {\n" +
                    "    \"no\": 21,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 22,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 23,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 24,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 25,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 26,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 27,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 28,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 29,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 30,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  }\n" +
                    "]";
        }

        if(page ==4){
            json = "[\n" +
                    "  {\n" +
                    "    \"no\": 31,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 32,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 33,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 34,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 35,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 36,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 37,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 38,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 39,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"no\": 40,\n" +
                    "    \"title\": \"this is title\",\n" +
                    "    \"date\": \"2018-09-20\",\n" +
                    "    \"contents\": \"this is contents\",\n" +
                    "    \"files\": [{\n" +
                    "      \"fName\": \"polo 카라티\",\n" +
                    "      \"fPath\": \"this is file path\"\n" +
                    "    }]\n" +
                    "  }\n" +
                    "]";
        }
        return json;
    }
}
