package com.example.skuniv.fleamarket2.view.locationView;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.adapter.GoodsListAdapter;
import com.example.skuniv.fleamarket2.adapter.ShopListAdapter;
import com.example.skuniv.fleamarket2.databinding.ActivitySectionBinding;
import com.example.skuniv.fleamarket2.databinding.ShopItemBinding;
import com.example.skuniv.fleamarket2.databinding.ShopSelectDialogBinding;
import com.example.skuniv.fleamarket2.model.locatonModel.Goods;
import com.example.skuniv.fleamarket2.model.locatonModel.SectionModel;
import com.example.skuniv.fleamarket2.model.locatonModel.ShopModel;
import com.example.skuniv.fleamarket2.viewModel.locationViewModel.GoodsListViewModel;
import com.example.skuniv.fleamarket2.viewModel.locationViewModel.SectionCommand;
import com.example.skuniv.fleamarket2.viewModel.locationViewModel.ShopViewModel;
import com.example.skuniv.fleamarket2.viewModel.locationViewModel.ShopsViewModel;


import java.util.List;

public class SectionActivity extends AppCompatActivity {
    ShopsViewModel shopsViewModel = new ShopsViewModel();

    private ShopSelectDialogBinding dialogBinding;
    private ShopSelectDialog dialog;
    SectionCommand sectionCommand;

    ActivitySectionBinding sectionBinding;
    ShopItemBinding shopItemBinding;
    SectionModel sectionModel;
    String json;
    List<ShopModel> shops;
    List<Goods> goodsArrayList;
    GoodsListViewModel goodsListViewModel;
    GoodsListAdapter goodsListAdapter;
    GoodsRecyclerDialog recyclerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // activity_section과 databiding할 객체 생성
        sectionBinding = DataBindingUtil.setContentView(this, R.layout.activity_section);
        Log.i("section","==========="+getIntent().getStringExtra("section"));
        // section model객체 생성
        // 나중에 각 섹션별로 값 다르게 넣어야 함
        sectionModel = new SectionModel(getIntent().getStringExtra("section"),"1");

        //sectionCommand 객체 생성
        sectionCommand = new SectionCommand(sectionModel, sectionBinding,shopsViewModel);

        // activity_section의 sectionModel 변수에 sectionModel 넣음
        sectionBinding.setSectionModel(sectionModel);

        // activity_section의 ShopModel 변수에 shopsViewModel 넣음
        sectionBinding.setShopModel(shopsViewModel);

        /*shopItemBinding = DataBindingUtil.setContentView(this,R.layout.shop_item);
        Myhandler myhandler = new Myhandler(this,shopItemBinding);
        shopItemBinding.setHandler(myhandler);*/

        //select diaolg 띄우기
        sectionBinding.selectId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new ShopSelectDialog(SectionActivity.this,sectionModel,sectionCommand);
                dialog.show();

                //디스플레이의 해상도를 가져옴
                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);

                //비율에 맞게 다이얼로그 크기를 지정
                Window window = dialog.getWindow();

                int x = (int)(size.x * 0.8f);
                int y = (int)(size.y * 0.9f);

                window.setLayout(x,y);
            }
        });

        sectionCommand.getShopList();

        sectionBinding.listId.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("ShopClickListener", "call==========" + i + "======="+l);

                recyclerDialog = new GoodsRecyclerDialog(SectionActivity.this, shopsViewModel.shops.get(i).goods);
                recyclerDialog.show();
            }
        });
    }

    //listView adapter 생성
    @BindingAdapter("app:items")
    public static void setShopList(ListView listView, ObservableArrayList<ShopViewModel> shops){
        ShopListAdapter adapter;
        //adapter 없을 때 adapter 생성
        if(listView.getAdapter() == null){
            adapter = new ShopListAdapter();
            listView.setAdapter(adapter);
        }
        else {
            // 있으면 getAdapter
            adapter = (ShopListAdapter) listView.getAdapter();
        }
        adapter.addAll(shops);
       //Log.i("adapter", shops.get(0).getGoods().get(0).getImage());
    }

    public String getJson(){
        String jsonObject;

        jsonObject = "[\n" +
                "    {\n" +
                "        \"no\": 1,\n" +
                "        \"location\": \"a\",\n" +
                "        \"shop\": \"A01\",\n" +
                "        \"goods\": [\n" +
                "            {\n" +
                "                \"name\": \"polo 카라티\",\n" +
                "                \"price\": 5000,\n" +
                "                \"quantity\": 2,\n" +
                "                \"category\": \"옷\",\n" +
                "                \"image\": \"http://13.125.128.130/static/bazaar_img/image_01.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"Tepal 다리미\",\n" +
                "                \"price\": 25000,\n" +
                "                \"quantity\": 1,\n" +
                "                \"category\": \"디지털/가전\",\n" +
                "                \"image\": \"http://13.125.128.130/static/bazaar_img/image_02.jpg\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"no\": 2,\n" +
                "        \"location\": \"a\",\n" +
                "        \"shop\": \"A02\",\n" +
                "        \"goods\": [\n" +
                "            {\n" +
                "                \"name\": \"polo 카라티\",\n" +
                "                \"price\": 5000,\n" +
                "                \"quantity\": 2,\n" +
                "                \"category\": \"옷\",\n" +
                "                \"image\": \"http://13.125.128.130/static/bazaar_img/image_01.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"Tepal 다리미\",\n" +
                "                \"price\": 25000,\n" +
                "                \"quantity\": 1,\n" +
                "                \"category\": \"디지털/가전\",\n" +
                "                \"image\": \"http://13.125.128.130/static/bazaar_img/image_02.jpg\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"no\": 3,\n" +
                "        \"location\": \"a\",\n" +
                "        \"shop\": \"A03\",\n" +
                "        \"goods\": [\n" +
                "            {\n" +
                "                \"name\": \"polo 카라티\",\n" +
                "                \"price\": 5000,\n" +
                "                \"quantity\": 2,\n" +
                "                \"category\": \"옷\",\n" +
                "                \"image\": \"http://13.125.128.130/static/bazaar_img/image_01.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"Tepal 다리미\",\n" +
                "                \"price\": 25000,\n" +
                "                \"quantity\": 1,\n" +
                "                \"category\": \"디지털/가전\",\n" +
                "                \"image\": \"http://13.125.128.130/static/bazaar_img/image_02.jpg\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"no\": 4,\n" +
                "        \"location\": \"a\",\n" +
                "        \"shop\": \"A04\",\n" +
                "        \"goods\": [\n" +
                "            {\n" +
                "                \"name\": \"polo 카라티\",\n" +
                "                \"price\": 5000,\n" +
                "                \"quantity\": 2,\n" +
                "                \"category\": \"옷\",\n" +
                "                \"image\": \"http://13.125.128.130/static/bazaar_img/image_01.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"Tepal 다리미\",\n" +
                "                \"price\": 25000,\n" +
                "                \"quantity\": 1,\n" +
                "                \"category\": \"디지털/가전\",\n" +
                "                \"image\": \"http://13.125.128.130/static/bazaar_img/image_02.jpg\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"no\": 5,\n" +
                "        \"location\": \"a\",\n" +
                "        \"shop\": \"A05\",\n" +
                "        \"goods\": [\n" +
                "            {\n" +
                "                \"name\": \"polo 카라티\",\n" +
                "                \"price\": 5000,\n" +
                "                \"quantity\": 2,\n" +
                "                \"category\": \"옷\",\n" +
                "                \"image\": \"http://13.125.128.130/static/bazaar_img/image_01.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"Tepal 다리미\",\n" +
                "                \"price\": 25000,\n" +
                "                \"quantity\": 1,\n" +
                "                \"category\": \"디지털/가전\",\n" +
                "                \"image\": \"http://13.125.128.130/static/bazaar_img/image_02.jpg\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"no\": 6,\n" +
                "        \"location\": \"a\",\n" +
                "        \"shop\": \"A06\",\n" +
                "        \"goods\": [\n" +
                "            {\n" +
                "                \"name\": \"polo 카라티\",\n" +
                "                \"price\": 5000,\n" +
                "                \"quantity\": 2,\n" +
                "                \"category\": \"옷\",\n" +
                "                \"image\": \"http://13.125.128.130/static/bazaar_img/image_01.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"Tepal 다리미\",\n" +
                "                \"price\": 25000,\n" +
                "                \"quantity\": 1,\n" +
                "                \"category\": \"디지털/가전\",\n" +
                "                \"image\": \"http://13.125.128.130/static/bazaar_img/image_02.jpg\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"no\": 7,\n" +
                "        \"location\": \"a\",\n" +
                "        \"shop\": \"A07\",\n" +
                "        \"goods\": [\n" +
                "            {\n" +
                "                \"name\": \"polo 카라티\",\n" +
                "                \"price\": 5000,\n" +
                "                \"quantity\": 2,\n" +
                "                \"category\": \"옷\",\n" +
                "                \"image\": \"http://13.125.128.130/static/bazaar_img/image_01.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"Tepal 다리미\",\n" +
                "                \"price\": 25000,\n" +
                "                \"quantity\": 1,\n" +
                "                \"category\": \"디지털/가전\",\n" +
                "                \"image\": \"http://13.125.128.130/static/bazaar_img/image_02.jpg\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"no\": 8,\n" +
                "        \"location\": \"a\",\n" +
                "        \"shop\": \"A08\",\n" +
                "        \"goods\": [\n" +
                "            {\n" +
                "                \"name\": \"polo 카라티\",\n" +
                "                \"price\": 5000,\n" +
                "                \"quantity\": 2,\n" +
                "                \"category\": \"옷\",\n" +
                "                \"image\": \"http://13.125.128.130/static/bazaar_img/image_01.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"Tepal 다리미\",\n" +
                "                \"price\": 25000,\n" +
                "                \"quantity\": 1,\n" +
                "                \"category\": \"디지털/가전\",\n" +
                "                \"image\": \"http://13.125.128.130/static/bazaar_img/image_02.jpg\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"no\": 9,\n" +
                "        \"location\": \"a\",\n" +
                "        \"shop\": \"A09\",\n" +
                "        \"goods\": [\n" +
                "            {\n" +
                "                \"name\": \"polo 카라티\",\n" +
                "                \"price\": 5000,\n" +
                "                \"quantity\": 2,\n" +
                "                \"category\": \"옷\",\n" +
                "                \"image\": \"http://13.125.128.130/static/bazaar_img/image_01.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"Tepal 다리미\",\n" +
                "                \"price\": 25000,\n" +
                "                \"quantity\": 1,\n" +
                "                \"category\": \"디지털/가전\",\n" +
                "                \"image\": \"http://13.125.128.130/static/bazaar_img/image_02.jpg\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"no\": 10,\n" +
                "        \"location\": \"a\",\n" +
                "        \"shop\": \"A10\",\n" +
                "        \"goods\": [\n" +
                "            {\n" +
                "                \"name\": \"polo 카라티\",\n" +
                "                \"price\": 5000,\n" +
                "                \"quantity\": 2,\n" +
                "                \"category\": \"옷\",\n" +
                "                \"image\": \"http://13.125.128.130/static/bazaar_img/image_01.jpg\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"Tepal 다리미\",\n" +
                "                \"price\": 25000,\n" +
                "                \"quantity\": 1,\n" +
                "                \"category\": \"디지털/가전\",\n" +
                "                \"image\": \"http://13.125.128.130/static/bazaar_img/image_02.jpg\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "]";

        return jsonObject;
    }
}
