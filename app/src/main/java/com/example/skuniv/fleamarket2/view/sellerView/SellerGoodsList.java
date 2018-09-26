package com.example.skuniv.fleamarket2.view.sellerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.skuniv.fleamarket2.adapter.GoodsListAdapter;
import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.databinding.SellerGoodsListBinding;
import com.example.skuniv.fleamarket2.model.AdminSellerModel.UserModel;
import com.example.skuniv.fleamarket2.viewModel.AdminSellerViewModel.SellerCommand;
import com.example.skuniv.fleamarket2.viewModel.locationViewModel.GoodsViewModel;
import com.example.skuniv.fleamarket2.viewModel.locationViewModel.ShopViewModel;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SellerGoodsList extends AppCompatActivity {
    private String selectedImagePath;
    private static final int REQ_CODE_SELECT_IMAGE = 100;
    Uri selectedImageUri;
    SellerGoodsListBinding sellerGoodsListBinding;
    UserModel userModel;
    static ShopViewModel shopViewModel;
    static Context context;
    SellerCommand sellerCommand;
    static GoodsListAdapter adapter;
    SellerGoodsList sellerGoodsListview;
    SellerGoodsUpdateDialog sellerGoodsUpdateDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sellerGoodsListBinding = DataBindingUtil.setContentView(this, R.layout.seller_goods_list);

        userModel = (UserModel) getIntent().getSerializableExtra("user");
        shopViewModel = new ShopViewModel();
        context = this;
        sellerGoodsListview = this;
        sellerCommand = new SellerCommand(context, userModel, shopViewModel, sellerGoodsListview);

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
                sellerGoodsUpdateDialog = new SellerGoodsUpdateDialog(context, userModel, shopViewModel, sellerGoodsListview, sellerCommand);
                sellerGoodsUpdateDialog.show();
            }
        });

        sellerGoodsListBinding.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQ_CODE_SELECT_IMAGE);
                //Glide.with(context).load(selectedImagePath).override(300,300).into(sellerGoodsListBinding.imageView);
            }
        });
    }

    public void getImage(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
        intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQ_CODE_SELECT_IMAGE);

    }

    @BindingAdapter("app:items")
    public static void bindItem(RecyclerView recyclerView, ObservableArrayList<GoodsViewModel> goodsList) {
        //= (GoodsListAdapter) recyclerView.getAdapter();
        if (recyclerView.getAdapter() == null) {
            adapter = new GoodsListAdapter(goodsList, context);
            recyclerView.setAdapter(adapter);
        } else {
            // 있으면 getAdapter
            adapter = (GoodsListAdapter) recyclerView.getAdapter();
            adapter.setItem(goodsList);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Toast.makeText(getBaseContext(), "resultCode : " + resultCode + " requestCode : " + requestCode, Toast.LENGTH_SHORT).show();
        if (requestCode == REQ_CODE_SELECT_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                try {
                    //Uri에서 이미지 이름을 얻어온다.
                    //String name_Str = getImageNameToUri(data.getData());
                    //이미지 데이터를 비트맵으로 받아온다.
                    Bitmap image_bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                    //배치해놓은 ImageView에 set
                    sellerGoodsUpdateDialog.sellerGoodsUpdateDialogBinding.imageView.setImageBitmap(image_bitmap);
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public String getImageNameToUri(Uri data)
    {
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(data, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

        cursor.moveToFirst();

        String imgPath = cursor.getString(column_index);
        String imgName = imgPath.substring(imgPath.lastIndexOf("/")+1);

        return imgName;
    }
}