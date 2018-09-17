package com.example.skuniv.fleamarket2.view.locationView;

import android.app.Dialog;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.WindowManager;

import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.adapter.GoodsListAdapter;
import com.example.skuniv.fleamarket2.databinding.GoodsRecyclerBinding;
import com.example.skuniv.fleamarket2.viewModel.locationViewModel.GoodsViewModel;

public class GoodsRecyclerDialog extends Dialog{

    public ObservableArrayList<GoodsViewModel> goodsList;
    private GoodsListAdapter mAdapter;
    public static Context context;

    public GoodsRecyclerDialog(Context context, ObservableArrayList<GoodsViewModel> goodsList) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.context = context;
        this.goodsList = goodsList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // 다이얼로그 외부 화면 흐리게 표현
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);

        // goods_recycler binding 객체 생성, layout 연결
        GoodsRecyclerBinding binding = (GoodsRecyclerBinding)
                DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.goods_recycler, null, false);
        setContentView(binding.getRoot());

        Log.i("Goods dialog",""+goodsList.size());

        // 레이아웃 매니져, 어댑터 생성 후 recycler에 set 함
        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        mAdapter = new GoodsListAdapter(goodsList, getContext());

        binding.recyclerId.setLayoutManager(llm);
        binding.recyclerId.setAdapter(mAdapter);
        binding.setGoodsList(goodsList);
    }

    @BindingAdapter("app:items")
    public static void bindItem(RecyclerView recyclerView, ObservableArrayList<GoodsViewModel> goods) {
        GoodsListAdapter adapter; //= (GoodsListAdapter) recyclerView.getAdapter();
        if(recyclerView.getAdapter() == null){
            adapter = new GoodsListAdapter(goods, context);
            recyclerView.setAdapter(adapter);
        }
        else {
            // 있으면 getAdapter
            adapter = (GoodsListAdapter) recyclerView.getAdapter();
        }
    }

}
