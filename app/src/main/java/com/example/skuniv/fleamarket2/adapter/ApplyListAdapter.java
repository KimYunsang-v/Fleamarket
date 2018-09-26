package com.example.skuniv.fleamarket2.adapter;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.skuniv.fleamarket2.databinding.ApplyItemBinding;
import com.example.skuniv.fleamarket2.databinding.ApplyListItemBinding;
import com.example.skuniv.fleamarket2.viewModel.AdminSellerViewModel.AdminCommand;
import com.example.skuniv.fleamarket2.viewModel.AdminSellerViewModel.ApplyItemViewModel;
import com.example.skuniv.fleamarket2.viewModel.AdminSellerViewModel.ApplyMetaViewModel;

public class ApplyListAdapter extends RecyclerView.Adapter<ApplyViewHolder> {
    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG =0;
    private OnLoadMoreListener onLoadMoreListener;
    private LinearLayoutManager linearLayoutManager;

    private boolean isMoreLoading = false;
    private int visibleThreshold = 1;
    int firstVisibleItem, visibleItemCount, totalItemCount, lastVisibleItem;

    public ObservableArrayList<ApplyItemViewModel> applyList;
    Context context;
    AdminCommand adminCommand;
    ApplyMetaViewModel applyMetaViewModel;

    public interface OnLoadMoreListener{
        void onLoadMore();
    }

    public void setLinearLayoutManager(LinearLayoutManager linearLayoutManager) {
        this.linearLayoutManager = linearLayoutManager;
    }

    public ApplyListAdapter(ObservableArrayList<ApplyItemViewModel> applyList, Context context, AdminCommand adminCommand, OnLoadMoreListener onLoadMoreListener,
                            ApplyMetaViewModel applyMetaViewModel){
        this.applyList = applyList;
        this.context = context;
        this.adminCommand = adminCommand;
        this.onLoadMoreListener = onLoadMoreListener;
        this.applyMetaViewModel = applyMetaViewModel;
//        System.out.println("==============="+shopsList.get(1));
    }

    public void setRecyclerView(RecyclerView mView){
        mView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                visibleItemCount = recyclerView.getChildCount();
                totalItemCount = linearLayoutManager.getItemCount();
                firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                Log.d("total", totalItemCount + "");
                Log.d("visible", visibleItemCount + "");

                Log.d("first", firstVisibleItem + "");
                Log.d("last", lastVisibleItem + "");
                if (totalItemCount < applyMetaViewModel.getCount().get()) {
                    if (!isMoreLoading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
                        if (onLoadMoreListener != null) {
                            onLoadMoreListener.onLoadMore();
                            System.out.println("onLoadMore()------");
                        }
                        isMoreLoading = true;
                    }
                }
            }
        });
    }

    // 현재 로딩중이면 프로그레스바 리턴 or 아니면 아이템 리턴
    /*@Override
    public int getItemViewType(int position) {
        return itemList.get(position) != null ? VIEW_ITEM : VIEW_PROG;
    }*/

    @Override
    public ApplyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //만약 타입이 view_item이면 아이템 추가
        //if(viewType == VIEW_ITEM)
        ApplyListItemBinding binding = ApplyListItemBinding.
                inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ApplyViewHolder(binding, context);
        //아니면 프로그레스바 아이템 추가
        //else{
    }

    public void setApplyList(ObservableArrayList<ApplyItemViewModel> applyList) {
        this.applyList = applyList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ApplyViewHolder holder, int position) {
        ApplyItemViewModel apply = applyList.get(position);
        holder.bind(apply);
    }

    public void setMoreLoading(boolean isMoreLoading) {
        this.isMoreLoading=isMoreLoading;
    }

    void setItem(ObservableArrayList<ApplyItemViewModel> applyList) {
        if (applyList == null) {
            return;
        }
        this.applyList = applyList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return applyList.size();
    }
}

class ApplyViewHolder extends RecyclerView.ViewHolder {
    ApplyListItemBinding binding;
    Context context;

    //ViewHolder 생성
    public ApplyViewHolder(ApplyListItemBinding binding, Context context) {
        super(binding.getRoot());
        this.binding = binding;
        this.context = context;
    }

    void bind(ApplyItemViewModel apply) {
        //Glide.with(context).load(shop.goods.get().getImage()).override(300, 300).into(binding.imageId);
        binding.setApply(apply);
    }
}
