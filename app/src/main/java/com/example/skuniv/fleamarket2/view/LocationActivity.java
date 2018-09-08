package com.example.skuniv.fleamarket2.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.skuniv.fleamarket2.R;

public class LocationActivity extends AppCompatActivity {

    //ActivityLocationBinding locationBinding;
    Button sectionA_btn,sectionB_btn,sectionC_btn,sectionD_btn,sectionE_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        //locationBinding = DataBindingUtil.setContentView(this,R.layout.activity_location);


        sectionA_btn = (Button)findViewById(R.id.sectionA_btn);
        sectionB_btn = (Button)findViewById(R.id.sectionB_btn);
        sectionC_btn = (Button)findViewById(R.id.sectionC_btn);
        sectionD_btn = (Button)findViewById(R.id.sectionD_btn);
        sectionE_btn = (Button)findViewById(R.id.sectionE_btn);

        sectionA_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SectionActivity.class);
                startActivity(intent);
            }
        });
    }
}
