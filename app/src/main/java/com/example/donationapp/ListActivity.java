package com.example.donationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

import com.example.donationapp.Adapter.NGOAdapter;
import com.example.donationapp.Interface.RecylerViewClicked;
import com.example.donationapp.POJO.NGO;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity implements RecylerViewClicked {

    @BindView(R.id.recler)
    RecyclerView recyclerView;

    private List<NGO> NGOList = new ArrayList<>();
    private NGOAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();

        NGOList.add(new NGO("Bachpan","Rajkot","1277837376728"));
        NGOList.add(new NGO("HelpOther","Ahmedabad","7261526526722"));
        if(NGOList!=null) {
            adapter = new NGOAdapter(NGOList, this, this::onClick);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onClick(int i) {
        Toast.makeText(this,"click"+i,Toast.LENGTH_LONG).show();
    }
}
