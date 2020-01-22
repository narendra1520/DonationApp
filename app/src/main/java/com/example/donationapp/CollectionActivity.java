package com.example.donationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CollectionActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.map_btn)
    Button map_btn;
    @BindView(R.id.cal_btn)
    Button cal_btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        ButterKnife.bind(this);
        map_btn.setOnClickListener(this);
        cal_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.map_btn) {
            map();
        }
        else if(v.getId()==R.id.cal_btn){
            call();
        }
    }



    private void map()
    {

        Toast.makeText(this,"Map Success",Toast.LENGTH_LONG).show();


    }
    private void call() {
        Toast.makeText(this,"call Success",Toast.LENGTH_LONG).show();
    }

}
