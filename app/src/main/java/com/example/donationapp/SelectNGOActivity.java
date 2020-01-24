package com.example.donationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.donationapp.Adapter.NGO_select_Adapter;
import com.example.donationapp.Api.RetrofitClient;
import com.example.donationapp.Interface.RecylerViewClicked;
import com.example.donationapp.POJO.NGO;
import com.example.donationapp.POJO.NGOHolder;
import com.example.donationapp.POJO.NGORes;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        String type = getIntent().getStringExtra("type");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();

        Call<NGORes> responseCall1 = RetrofitClient.getInstance()
                .getInterPreter().getNGO(type);
        responseCall1.enqueue(new Callback<NGORes>() {
            @Override
            public void onResponse(Call<NGORes> call, Response<NGORes> response) {
                NGORes response1 = response.body();
                NGOList = response1.getNgo();
                NGO_select_Adapter adapter = new NGO_select_Adapter(NGOList,SelectNGOActivity.this, SelectNGOActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<NGORes> call, Throwable t) {
                Toast.makeText(SelectNGOActivity.this, "Error Occured", Toast.LENGTH_LONG).show();
            }
        });

        if(NGOList!=null) {
            adapter = new NGO_select_Adapter(NGOList, this, this::onClick);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onClick(int i) {
        NGOHolder ngoHolder = NGOHolder.getInstance();
        ngoHolder.setNgo(NGOList.get(i));

        Intent intent = new Intent(this, CollListActivity.class);
        startActivity(intent);
    }
}
