package com.example.skuniv.fleamarket2.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.view.categoryView.CategoryActivity;
import com.example.skuniv.fleamarket2.databinding.ActivityMainBinding;
import com.example.skuniv.fleamarket2.view.locationView.LocationActivity;
import com.example.skuniv.fleamarket2.view.noticeView.NoticeActivity;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private final int MY_PERMISSIONS_REQUEST = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);


        binding.locationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LocationActivity.class);
                startActivity(intent);
            }
        });

        binding.categoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CategoryActivity.class);
                startActivity(intent);
            }
        });

        binding.noticeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NoticeActivity.class);
                startActivity(intent);
            }
        });

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MY_PERMISSIONS_REQUEST);
        }
    }
}
