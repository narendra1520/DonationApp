package com.example.donationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.donationapp.POJO.NGO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NGOActivity extends Activity implements View.OnClickListener{

    @BindView(R.id.donatebtn)
    Button donatebtn;
    @BindView(R.id.callbtn)
    Button callbtn;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo);
        ButterKnife.bind(this);
        donatebtn.setOnClickListener(this);
        callbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
       // if(v.getId()==R.id.donatebtn){
         //   donate();
        //}
            if(v.getId()==R.id.callbtn){
            call();

        }
    }

    public void donate()
    {

       // Toast.makeText(this,"donate Success",Toast.LENGTH_LONG).show();
        Intent ngo = new Intent(NGOActivity.this,DonateActivity.class);
        startActivity(ngo);


    }
    private void call(){
        Toast.makeText(this,"call Success",Toast.LENGTH_LONG).show();
    }
}