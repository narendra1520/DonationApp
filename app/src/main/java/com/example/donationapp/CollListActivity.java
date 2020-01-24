package com.example.donationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.donationapp.Adapter.Coll_List_Adapter;
import com.example.donationapp.Api.RetrofitClient;
import com.example.donationapp.Interface.RecylerViewClicked;
import com.example.donationapp.POJO.Coll;
import com.example.donationapp.POJO.CollRes;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CollListActivity extends AppCompatActivity implements RecylerViewClicked {

    @BindView(R.id.reclear)
    RecyclerView recyclerView;

    private List<Coll> CollList = new ArrayList<>();
    private Coll_List_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coll_list);

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();

        Call<CollRes> responseCall1 = RetrofitClient.getInstance()
                .getInterPreter().getcoll();
        responseCall1.enqueue(new Callback<CollRes>() {
            @Override
            public void onResponse(Call<CollRes> call, Response<CollRes> response) {
                CollRes response1 = response.body();
                CollList = response1.getColl();
                Coll_List_Adapter adapter = new Coll_List_Adapter(CollList,CollListActivity.this,
                        CollListActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<CollRes> call, Throwable t) {
                Toast.makeText(CollListActivity.this, "Error Occurred", Toast.LENGTH_LONG).show();
            }
        });

        if(CollList !=null) {
            adapter = new Coll_List_Adapter(CollList, this, this::onClick);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onClick(int i) {
        Intent intent = new Intent(this, CollDetailActivity.class);
        intent.putExtra("tag", CollList.get(i).getTag());
        startActivity(intent);
    }
}
