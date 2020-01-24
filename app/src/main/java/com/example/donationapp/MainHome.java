package com.example.donationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainHome extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.homebtn)
    ImageButton home;
    @BindView(R.id.groupbtn)
    ImageButton group;
    @BindView(R.id.new_collection)
    ImageButton collection;
    @BindView(R.id.settingbtn)
    ImageButton setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainhome);
        ButterKnife.bind(this);
        home.setOnClickListener(this);
        group.setOnClickListener(this);
        collection.setOnClickListener(this);
        setting.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.homebtn) {
            Intent intent = new Intent(this, NGOFilter.class);
            startActivity(intent);
        }
        else if(v.getId()== R.id.groupbtn) {
            Intent intent = new Intent(this, NgoListActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.new_collection){
            Intent intent = new Intent(this, NewcollectionActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.optinal_menu,menu);
        return true;
    }
}
