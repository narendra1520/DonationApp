package com.example.donationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CollDetailActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.map_btn)
    Button map_btn;
    @BindView(R.id.cal_btn)
    Button cal_btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coll_detail);
        ButterKnife.bind(this);
        map_btn.setOnClickListener(this);
        cal_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.map_btn) {
            String uri = "https://goo.gl/maps/7aYEv2kHxjbRDXv37";
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(uri));
            startActivity(intent);
        }
        else if(v.getId()==R.id.cal_btn){
            String uri = "tel:" + "+919016214426";
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(uri));
            startActivity(intent);
        }
    }
}
