package com.example.donationapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NgoDetailActivity extends Activity implements View.OnClickListener{

    @BindView(R.id.moneybtn)
    Button moneybtn;
    @BindView(R.id.callbtn)
    Button callbtn;
    @BindView(R.id.itembtn)
    Button itembtn;
    @BindView(R.id.mapbtn)
    Button mapbtn;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo_detail);
        ButterKnife.bind(this);
        moneybtn.setOnClickListener(this);
        callbtn.setOnClickListener(this);
        itembtn.setOnClickListener(this);
        mapbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId()==R.id.moneybtn){
            Intent intent = new Intent(this, MoneyActivity.class);
            startActivity(intent);
        } else if(v.getId()==R.id.callbtn){
            String uri = "tel:" + "+919016214426";
            Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse(uri));
            startActivity(intent);
        }else if(v.getId()==R.id.itembtn){
            Intent intent = new Intent(this, NewcollectionActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.mapbtn){
            String uri = "https://goo.gl/maps/7aYEv2kHxjbRDXv37";
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(uri));
            startActivity(intent);
        }
    }
}