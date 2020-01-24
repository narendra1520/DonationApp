package com.example.donationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NGOFilter extends AppCompatActivity {

    @BindView(R.id.search_ngo)
    Button donate;

    String[] type_arr={"h","g"}, cate_arr={"h","k"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo_filter);

        ButterKnife.bind(this);

        Spinner mysp = findViewById(R.id.spn_type);
        ArrayAdapter<String> ad= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, type_arr);
        mysp.setAdapter(ad);

        Spinner mysp1 = findViewById(R.id.spn_cate);
        ArrayAdapter<String> ad1= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, cate_arr);
        mysp1.setAdapter(ad1);

        donate.setOnClickListener(v -> {
            Intent intent = new Intent(NGOFilter.this, SelectNGOActivity.class);
            startActivity(intent);
        });
    }
}
