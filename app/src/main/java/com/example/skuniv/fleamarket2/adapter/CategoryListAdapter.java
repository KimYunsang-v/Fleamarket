package com.example.skuniv.fleamarket2.adapter;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.skuniv.fleamarket2.databinding.CategoryItemBinding;
import com.bumptech.glide.Glide;
import com.example.skuniv.fleamarket2.viewModel.categoryViewmodel.CategoryCommand;
import com.example.skuniv.fleamarket2.viewModel.categoryViewmodel.CategoryShopViewModel;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryViewHolder>{

    public ObservableArrayList<CategoryShopViewModel> shopsList;
    Context context;
    CategoryCommand categoryCommand;

    public CategoryListAdapter(ObservableArrayList<CategoryShopViewModel> shopsList, Context context, CategoryCommand categoryCommand){
        this.shopsList = shopsList;
        this.context = context;
        this.categoryCommand = categoryCommand;
//        System.out.println("==============="+shopsList.get(1));
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CategoryItemBinding binding = CategoryItemBinding.
                inflate(LayoutInflater.from(parent.getContext()), parent, false);
        binding.setCommand(categoryCommand);
        return new CategoryViewHolder(binding, context);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        CategoryShopViewModel shop = shopsList.get(position);
        holder.bind(shop);
    }

    void setItem(ObservableArrayList<CategoryShopViewModel> goodsList) {
        if (goodsList == null) {
            return;
        }
        this.shopsList = goodsList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return shopsList.size();
    }
}

class CategoryViewHolder extends RecyclerView.ViewHolder {
    CategoryItemBinding binding;
    Context context;

    //ViewHolder 생성
    public CategoryViewHolder(CategoryItemBinding binding, Context context) {
        super(binding.getRoot());
        this.binding = binding;
        this.context = context;
    }

    void bind(CategoryShopViewModel shop) {
        Log.i("bind", "=======" + shop.goods.get().getImage());
        Glide.with(context).load(shop.goods.get().getImage()).override(300, 300).into(binding.imageId);
        binding.setShop(shop);
    }
}
