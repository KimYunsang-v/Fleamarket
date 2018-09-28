package com.example.skuniv.fleamarket2.view.categoryView;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.viewModel.categoryViewmodel.CategoryShopViewModel;
import com.example.skuniv.fleamarket2.viewModel.locationViewModel.SelectDialogItemsModel;
import com.example.skuniv.fleamarket2.databinding.ShopMapBinding;

import org.w3c.dom.Text;

public class ShopMapDialog extends Dialog {


    CategoryShopViewModel categoryShopViewModel;
    private ShopMapBinding dialogBinding;

    TextView[] shopText;

    String shop,shopNum;
    public ShopMapDialog(Context context, CategoryShopViewModel categoryShopViewModel) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.categoryShopViewModel = categoryShopViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //shop = categoryShopViewModel.shop.get();
        shop = "A02";
        String location = "a";
        shopNum = shop.split(location.toUpperCase())[1];
        System.out.println("shop num    "+shopNum);

        // 다이얼로그 외부 화면 흐리게 표현
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);

        dialogBinding = (ShopMapBinding)
                DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.shop_map, null, false);
        setContentView(dialogBinding.getRoot());

        dialogBinding.setMap(this);

        setShopList();

        shopText[Integer.parseInt(shopNum)-1].setBackgroundColor(getContext().getResources().getColor(R.color.colorPrimaryDark));
        //DialogBinding.setSelect(shopNum);
        //setBack = new Boolean[120];
        //setBack[shopNum] = true;
        //dialogBinding.setShopList(setBack);
    }


    //@BindingAdapter({"bind:setColor"})
    public void setBackground(View view) {


        System.out.println("select shop map==="+view.getId());
    }

    public void setShopList(){
        shopText = new TextView[]{ dialogBinding.id1 , dialogBinding.id2, dialogBinding.id3, dialogBinding.id4,dialogBinding.id5,dialogBinding.id6,dialogBinding.id7,dialogBinding.id8,dialogBinding.id9,dialogBinding.id10,
                dialogBinding.id11,dialogBinding.id12,dialogBinding.id13,dialogBinding.id14,dialogBinding.id15,dialogBinding.id16,dialogBinding.id17,dialogBinding.id18,dialogBinding.id19,dialogBinding.id20,
                dialogBinding.id21,dialogBinding.id22,dialogBinding.id23,dialogBinding.id24,dialogBinding.id25,dialogBinding.id26,dialogBinding.id27,dialogBinding.id28,dialogBinding.id29,dialogBinding.id30,
                dialogBinding.id31,dialogBinding.id32,dialogBinding.id33,dialogBinding.id34,dialogBinding.id35,dialogBinding.id36,dialogBinding.id37,dialogBinding.id38,dialogBinding.id39,dialogBinding.id40,
                dialogBinding.id41,dialogBinding.id42,dialogBinding.id43,dialogBinding.id44,dialogBinding.id45,dialogBinding.id46,dialogBinding.id47,dialogBinding.id48,dialogBinding.id49,dialogBinding.id50,
                dialogBinding.id51,dialogBinding.id52,dialogBinding.id53,dialogBinding.id54,dialogBinding.id55,dialogBinding.id56,dialogBinding.id57,dialogBinding.id58,dialogBinding.id59,dialogBinding.id60,
                dialogBinding.id61,dialogBinding.id62,dialogBinding.id63,dialogBinding.id64,dialogBinding.id65,dialogBinding.id66,dialogBinding.id67,dialogBinding.id68,dialogBinding.id69,dialogBinding.id70,
                dialogBinding.id71,dialogBinding.id72,dialogBinding.id73,dialogBinding.id74,dialogBinding.id75,dialogBinding.id76,dialogBinding.id77,dialogBinding.id78,dialogBinding.id79,dialogBinding.id80 };
        }
}