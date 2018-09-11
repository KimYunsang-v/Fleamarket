package com.example.skuniv.fleamarket2.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.skuniv.fleamarket2.R;

public class CategoryListActivity extends AppCompatActivity {
    //ActivityCategoryListBinding categoryListBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
       // categoryListBinding = DataBindingUtil.setContentView(this, R.layout.activity_category_list);


    }
}
