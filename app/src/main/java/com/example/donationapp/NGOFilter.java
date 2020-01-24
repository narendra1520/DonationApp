package com.example.donationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NGOhomeActivity extends AppCompatActivity {

    @BindView(R.id.dobtn)
    Button donate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngohome);

        ButterKnife.bind(this);
        Spinner mysp = findViewById(R.id.spiner1);
       //ArrayAdapter<String> ad=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,R.array.name);
        //mysp.setAdapter(ad);

        Spinner mysp1 = findViewById(R.id.spiner);
       // ArrayAdapter<String> ad1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,getContentResolver(R.array.catagory);
        //mysp.setAdapter(ad1);

        donate.setOnClickListener(v -> {
            Intent intent = new Intent(NGOhomeActivity.this, Select_NGO.class);
            startActivity(intent);
        });

    }
}
