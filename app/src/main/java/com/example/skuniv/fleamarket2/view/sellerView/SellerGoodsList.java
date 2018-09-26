package com.example.skuniv.fleamarket2.view.sellerView;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.skuniv.fleamarket2.adapter.GoodsListAdapter;
import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.databinding.SellerGoodsListBinding;
import com.example.skuniv.fleamarket2.model.AdminSellerModel.UserModel;
import com.example.skuniv.fleamarket2.viewModel.AdminSellerViewModel.SellerCommand;
import com.example.skuniv.fleamarket2.viewModel.locationViewModel.GoodsViewModel;
import com.example.skuniv.fleamarket2.viewModel.locationViewModel.ShopViewModel;

public class SellerGoodsList extends AppCompatActivity {
    SellerGoodsListBinding sellerGoodsListBinding;
    UserModel userModel;
    ShopViewModel shopViewModel;
    static Context context;
    SellerCommand sellerCommand;
    static GoodsListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sellerGoodsListBinding = DataBindingUtil.setContentView(this,R.layout.seller_goods_list);

        userModel = (UserModel) getIntent().getSerializableExtra("user");
        shopViewModel = new ShopViewModel();
        context = this;

        sellerCommand = new SellerCommand(context, userModel, shopViewModel);

        sellerCommand.getShopModel();

        // 레이아웃 매니져, 어댑터 생성 후 recycler에 set 함
        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        adapter = new GoodsListAdapter(shopViewModel.goods, context);

        sellerGoodsListBinding.recyclerId.setLayoutManager(llm);
        sellerGoodsListBinding.recyclerId.setAdapter(adapter);
        sellerGoodsListBinding.setShop(shopViewModel);

        sellerGoodsListBinding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SellerGoodsUpdateDialog sellerGoodsUpdateDialog = new SellerGoodsUpdateDialog(context, userModel, shopViewModel);
                sellerGoodsUpdateDialog.show();
            }
        });
    }

    @BindingAdapter("app:items")
    public static void bindItem(RecyclerView recyclerView, ObservableArrayList<GoodsViewModel> goods) {
         //= (GoodsListAdapter) recyclerView.getAdapter();
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
