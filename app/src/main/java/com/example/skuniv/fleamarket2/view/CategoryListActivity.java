package com.example.skuniv.fleamarket2.view;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import com.example.skuniv.fleamarket2.adapter.GoodsListAdapter;
import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.databinding.ActivityCategoryListBinding;
import com.example.skuniv.fleamarket2.model.CategoryModel;
import com.example.skuniv.fleamarket2.viewmodel.CategoryCommand;
import com.example.skuniv.fleamarket2.viewmodel.GoodsListViewModel;
import com.example.skuniv.fleamarket2.viewmodel.GoodsViewModel;


public class CategoryListActivity extends AppCompatActivity {
    ActivityCategoryListBinding categoryListBinding;
    CategoryModel categoryModel;
    static Context context;
    GoodsListViewModel goodsListViewModel;
    CategoryCommand categoryCommand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categoryListBinding = DataBindingUtil.setContentView(this, R.layout.activity_category_list);
        categoryModel = new CategoryModel(getIntent().getStringExtra("category"),1);

        goodsListViewModel = new GoodsListViewModel();
        // 카테고리모델 셋팅
        categoryListBinding.setCategoryModel(categoryModel);
        context = this.getApplicationContext();
        categoryListBinding.setGoodsL(goodsListViewModel.getGoodsList());

        categoryCommand = new CategoryCommand(context, categoryListBinding, categoryModel, goodsListViewModel);

        categoryCommand.getGoodsList();

        categoryCommand.getAdapter();

        }
}
