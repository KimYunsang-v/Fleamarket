package com.example.skuniv.fleamarket2.view.categoryView;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.skuniv.fleamarket2.adapter.CategoryListAdapter;
import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.databinding.ActivityCategoryListBinding;
import com.example.skuniv.fleamarket2.databinding.CategoryItemBinding;
import com.example.skuniv.fleamarket2.model.categoryModel.CategoryModel;
import com.example.skuniv.fleamarket2.viewModel.categoryViewmodel.CategoryCommand;
import com.example.skuniv.fleamarket2.viewModel.categoryViewmodel.CategoryShopViewModel;
import com.example.skuniv.fleamarket2.viewModel.categoryViewmodel.CategoryShopsViewModel;


public class CategoryListActivity extends AppCompatActivity {
    ActivityCategoryListBinding categoryListBinding;
    CategoryModel categoryModel;
    static Context context;
    CategoryShopsViewModel categoryShopsViewModel;
    static CategoryCommand categoryCommand;
    CategoryItemBinding categoryItemBinding;
    CategoryListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categoryListBinding = DataBindingUtil.setContentView(this, R.layout.activity_category_list);

        /*categoryItemBinding = (CategoryItemBinding)
                DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.category_item, null, false);*/
        categoryModel = new CategoryModel(getIntent().getStringExtra("category"),1);

        categoryShopsViewModel = new CategoryShopsViewModel();
        // 카테고리모델 셋팅
        categoryListBinding.setCategoryModel(categoryModel);
        categoryListBinding.setShopsList(categoryShopsViewModel.getShops());

        categoryCommand = new CategoryCommand(this, categoryListBinding, categoryModel, categoryShopsViewModel);

        categoryCommand.getGoodsList();

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        Log.i("getAdapter","============");

        categoryListBinding.recyclerId2.setLayoutManager(llm);

        /*categoryItemBinding.mapId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/


        }

    //listView adapter 생성
    @BindingAdapter("app:items")
    public static void setShopList(RecyclerView recyclerView, ObservableArrayList<CategoryShopViewModel> shops){
        CategoryListAdapter adapter;
        //adapter 없을 때 adapter 생성
        if(recyclerView.getAdapter() == null){
            adapter = new CategoryListAdapter(shops, context,categoryCommand);
            recyclerView.setAdapter(adapter);
        }
        else {
            // 있으면 getAdapter
            adapter = (CategoryListAdapter) recyclerView.getAdapter();
        }
        //adapter.addAll(shops);
        //Log.i("adapter", shops.get(0).getGoods().get(0).getImage());
    }
}
