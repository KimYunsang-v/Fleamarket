package com.example.skuniv.fleamarket2.view.categoryView;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.databinding.ActivityCategoryBinding;


public class CategoryActivity extends AppCompatActivity {
    ActivityCategoryBinding categoryBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categoryBinding = DataBindingUtil.setContentView(this,R.layout.activity_category);
        categoryBinding.setCategory(this);
    }

    public void categoryClickListener(String category){
        Intent intent = new Intent(getApplicationContext(),CategoryListActivity.class);
        intent.putExtra("category",category);
        startActivity(intent);
    }
}