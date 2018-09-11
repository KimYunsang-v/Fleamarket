package com.example.skuniv.fleamarket2.view;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.skuniv.fleamarket2.databinding.ActivityLocationBinding;

import com.example.skuniv.fleamarket2.R;

public class LocationActivity extends AppCompatActivity {

    ActivityLocationBinding locationBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        locationBinding = DataBindingUtil.setContentView(this,R.layout.activity_location);
        locationBinding.setSection(this);

    }

    //@BindingAdapter("android:onClick")
    public void clickListener(String section){
        Intent intent = new Intent(getApplicationContext(),SectionActivity.class);
        intent.putExtra("section",section);
        startActivity(intent);
    }
}
