package com.example.skuniv.fleamarket2.viewModel.noticeViewModel;

import android.content.Context;
import android.util.Log;

import com.example.skuniv.fleamarket2.databinding.ActivityNoticeBinding;
import com.example.skuniv.fleamarket2.model.noticeModel.NoticeListModel;
import com.example.skuniv.fleamarket2.model.noticeModel.NoticeModel;
import com.example.skuniv.fleamarket2.retrofit.NetRetrofit;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoticeCommand {
    Context context;
    ActivityNoticeBinding categoryListBinding;
    NoticeListModel noticeListModel;
    NoticeItemsViewModel noticeItemsViewModel;
    NoticeCommand noticeCommand;
    List<NoticeModel> noticeList;
    Gson gson = new Gson();

    public NoticeCommand(Context context, ActivityNoticeBinding categoryListBinding, NoticeListModel noticeListModel, NoticeItemsViewModel noticeItemsViewModel){
        this.context = context;
        this.categoryListBinding = categoryListBinding;
        this.noticeListModel = noticeListModel;
        this.noticeItemsViewModel = noticeItemsViewModel;
        noticeCommand = this;
    }

    public void getNoticeList(){
        if (!(noticeListModel.getPage() <= 0)) {
            Call<List<NoticeModel>> res = NetRetrofit.getInstance().getService().getNoticeRepos(noticeListModel.getPage());
            Log.i("getGoodsList",""+res);
            res.enqueue(new Callback<List<NoticeModel>>() {
                @Override
                public void onResponse(Call<List<NoticeModel>> call, Response<List<NoticeModel>> response) {
                    Log.i("Retrofit", response.toString());
                    if (response.body() != null) {
                        noticeList = response.body();
                        Log.i("getShopList",""+gson.toJson(noticeList));
                        noticeItemsViewModel.setNoticeList(noticeList);
                        System.out.println(noticeItemsViewModel);
                        System.out.println(noticeItemsViewModel.getNoticeList());
                        //mAdapter = new CategoryListAdapter(categoryShopsViewModel.getShops(), context,categoryCommand);
                        //categoryListBinding.recyclerId2.setAdapter(mAdapter);
                        //getAdapter();
                    }
                }
                @Override
                public void onFailure(Call<List<NoticeModel>> call, Throwable t) {
                    Log.e("에러", t.getMessage());
                }
            });
        } else {
            Log.e("getNoticeList","getNoticeList error");
        }
    }

    public List<NoticeModel> jsonPaser(String jsonObject){

        Gson gson = new Gson();
        NoticeModel[] notice = gson.fromJson(jsonObject,  NoticeModel[].class);

        List<NoticeModel> noticeList = new ArrayList<>(Arrays.asList(notice));
        noticeItemsViewModel.setNoticeList(noticeList);
        // shops = shopData.getShops();
        System.out.println("jsonPaser===========");
        return noticeList;
    }
}
