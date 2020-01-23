package com.example.donationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import butterknife.BindView;

public class ngohomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngohome);

        Spinner mysp = findViewById(R.id.spiner1);
       //ArrayAdapter<String> ad=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,R.array.name);
        //mysp.setAdapter(ad);

        Spinner mysp1 = findViewById(R.id.spiner);
       // ArrayAdapter<String> ad1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,getContentResolver(R.array.catagory);
        //mysp.setAdapter(ad1);

    }
}
