package com.example.donationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.donationapp.Adapter.NGO_select_Adapter;
import com.example.donationapp.Interface.RecylerViewClicked;
import com.example.donationapp.POJO.NGO;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectNGOActivity extends AppCompatActivity implements RecylerViewClicked {

    @BindView(R.id.sel_ngo_rec)
    RecyclerView recyclerView;

    private List<NGO> NGOList = new ArrayList<>();
    private NGO_select_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_ngo);

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();

        NGOList.add(new NGO("Bachpan","Rajkot","Children","1277837376728"));
        NGOList.add(new NGO("HelpOther","Ahmedabad","Childer","7261526526722"));
        if(NGOList!=null) {
            adapter = new NGO_select_Adapter(NGOList, this, this::onClick);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onClick(int i) {
        Intent intent = new Intent(this, CollListActivity.class);
        startActivity(intent);
    }
}
