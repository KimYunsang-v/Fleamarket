package com.example.skuniv.fleamarket2.view.adminView;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.adapter.ApplyListAdapter;
import com.example.skuniv.fleamarket2.databinding.CurrentApplyBinding;
import com.example.skuniv.fleamarket2.model.AdminSellerModel.ApplyListModel;
import com.example.skuniv.fleamarket2.model.AdminSellerModel.UserModel;
import com.example.skuniv.fleamarket2.viewModel.AdminSellerViewModel.AdminCommand;
import com.example.skuniv.fleamarket2.viewModel.AdminSellerViewModel.ApplyItemViewModel;
import com.example.skuniv.fleamarket2.viewModel.AdminSellerViewModel.ApplyItemsViewModel;
import com.example.skuniv.fleamarket2.viewModel.AdminSellerViewModel.ApplyMetaViewModel;

public class CurrentApplyView extends AppCompatActivity implements ApplyListAdapter.OnLoadMoreListener{

    static CurrentApplyBinding currentApplyBinding;
    static AdminCommand adminCommand;
    static ApplyListAdapter applyListAdapter;
    static LinearLayoutManager listLlm;
    static Context context;
    static ApplyItemsViewModel applyItemsViewModel;
    static ApplyListAdapter.OnLoadMoreListener onLoadMoreListener;
    static ApplyMetaViewModel applyMetaViewModel;
    ApplyListModel applyListModel;
    UserModel userModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentApplyBinding = DataBindingUtil.setContentView(this, R.layout.current_apply);
        context = this;

        userModel = (UserModel) getIntent().getSerializableExtra("userModel");

        applyListModel = new ApplyListModel();
        applyItemsViewModel = new ApplyItemsViewModel();
        applyMetaViewModel = new ApplyMetaViewModel();
        adminCommand = new AdminCommand(context, userModel, applyListModel, applyItemsViewModel, applyMetaViewModel);
        onLoadMoreListener = this;

        listLlm = new LinearLayoutManager(this);
        listLlm.setOrientation(LinearLayoutManager.VERTICAL);
        currentApplyBinding.ListRecyclerId.setLayoutManager(listLlm);

        currentApplyBinding.setApplyList(applyItemsViewModel);

        adminCommand.jsonPaser(getJson(applyListModel.getPage()));

    }

    @Override
    public void onLoadMore() {
        Log.d("NoticeActivity_", "onLoadMore");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ///////이부분에을 자신의 프로젝트에 맞게 설정하면 됨
                //다음 페이지? 내용을 불러오는 부분
                applyListModel.setPage(applyListModel.getPage()+1);
                adminCommand.jsonPaser(getJson(applyListModel.getPage()));
                //noticeCommand.jsonPaser(getJson(noticeListModel.getPage()));
                applyListAdapter.setMoreLoading(false);
                //////////////////////////////////////////////////
                //mAdapter.setMoreLoading(false);
            }
        }, 2000);
        /*categoryModel.setPageNum(categoryModel.getPageNum()+1);
        categoryCommand.jsonPaser(getJson(categoryModel.getPageNum()));
        adapter.setMoreLoading(false);*/
    }

    @BindingAdapter("app:items")
    public static void setNoticeList(RecyclerView recyclerView, ObservableArrayList<ApplyItemViewModel> applyList){
        //adapter 없을 때 adapter 생성
        System.out.println("setShopList=============");
        if(recyclerView.getAdapter() == null){
            System.out.println("new categoryListAdapter");
            applyListAdapter = new ApplyListAdapter(applyItemsViewModel.applyList, context, adminCommand, onLoadMoreListener, applyMetaViewModel);
            applyListAdapter.setLinearLayoutManager(listLlm);
            recyclerView.setAdapter(applyListAdapter);
            applyListAdapter.setRecyclerView(currentApplyBinding.ListRecyclerId);
        }
        else {
            // 있으면 getAdapter
            applyListAdapter = (ApplyListAdapter) recyclerView.getAdapter();
            applyListAdapter.setApplyList(applyItemsViewModel.getApplyList());
            System.out.println("get adapter");
        }
        //adapter.addAll(shops);
        //Log.i("adapter", shops.get(0).getGoods().get(0).getImage());
    }

    public String getJson(int page){
        String json="";
        if(page == 1){
            json = "{\n" +
                    "items:[\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "}" +
                    "],\n" +
                    "meta:{\n" +
                    "\"count\": 45\n" +
                    "}\n" +
                    "}";
        } else if(page == 2){
            json = "{\n" +
                    "items:[\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "}" +
                    "],\n" +
                    "meta:{\n" +
                    "\"count\": 45\n" +
                    "}\n" +
                    "}";
        } else if(page == 3){
            json = "{\n" +
                    "items:[\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "}" +
                    "],\n" +
                    "meta:{\n" +
                    "\"count\": 45\n" +
                    "}\n" +
                    "}";
        } else if(page == 4){
            json = "{\n" +
                    "items:[\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "}" +
                    "],\n" +
                    "meta:{\n" +
                    "\"count\": 45\n" +
                    "}\n" +
                    "}";
        }else if(page == 5){
            json = "{\n" +
                    "items:[\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},\n" +
                    "{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "},{\n" +
                    "id: \"kim\",\n" +
                    "name: \"yunsang\",\n" +
                    "title: \"this is title\",\n" +
                    "contents: \"this is contents\",\n" +
                    "\"role\": 1.0,\n" +
                    "date: \"this is date\"\n" +
                    "}" +
                    "],\n" +
                    "meta:{\n" +
                    "\"count\": 45\n" +
                    "}\n" +
                    "}";
        }
        return json;
    }
}
