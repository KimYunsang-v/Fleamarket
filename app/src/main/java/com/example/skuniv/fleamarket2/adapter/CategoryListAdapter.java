package com.example.skuniv.fleamarket2.adapter;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.skuniv.fleamarket2.databinding.CategoryItemBinding;
import com.bumptech.glide.Glide;
import com.example.skuniv.fleamarket2.viewmodel.GoodsViewModel;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryViewHolder>{

    public ObservableArrayList<GoodsViewModel> goodsList;
    Context context;

    public CategoryListAdapter(ObservableArrayList<GoodsViewModel> goodsList, Context context){
        this.goodsList = goodsList;
        this.context = context;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CategoryItemBinding binding = CategoryItemBinding.
                inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CategoryViewHolder(binding, context);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        GoodsViewModel goods = goodsList.get(position);
        holder.bind(goods);
    }

    void setItem(ObservableArrayList<GoodsViewModel> goodsList) {
        if (goodsList == null) {
            return;
        }
        this.goodsList = goodsList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return goodsList.size();
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

    void bind(GoodsViewModel goods) {
        Log.i("bind", "=======" + goods.getImage().get());
        //Glide.with(context).load(goods.getImage().get()).override(300, 300).into(binding.imageId);
        binding.setGoods(goods);
    }
}
