package com.example.donationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.donationapp.Api.RetrofitClient;
import com.example.donationapp.POJO.CategoryRes;
import com.example.donationapp.POJO.NGO;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NGOFilter extends AppCompatActivity {

    @BindView(R.id.search_ngo)
    Button donate;
    private Spinner mysp, mysp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo_filter);

        ButterKnife.bind(this);

        Call<CategoryRes> responseCall = RetrofitClient.getInstance()
                .getInterPreter().getCategory();
        responseCall.enqueue(new Callback<CategoryRes>() {
            @Override
            public void onResponse(Call<CategoryRes> call, Response<CategoryRes> response) {

                Call<CategoryRes> responseCall1 = RetrofitClient.getInstance()
                        .getInterPreter().getCategory2();
                responseCall1.enqueue(new Callback<CategoryRes>() {
                    @Override
                    public void onResponse(Call<CategoryRes> call, Response<CategoryRes> response) {
                        CategoryRes response1 = response.body();
                        List<String> category = response1.getCat();

                        String[] cat = category.toArray(new String[0]);

                        mysp1 = findViewById(R.id.spn_cate);
                        ArrayAdapter<String> ad1 = new ArrayAdapter<>(NGOFilter.this, android.R.layout.simple_spinner_dropdown_item, cat);
                        mysp1.setAdapter(ad1);
                    }

                    @Override
                    public void onFailure(Call<CategoryRes> call, Throwable t) {
                        Toast.makeText(NGOFilter.this, "Error Occurred", Toast.LENGTH_LONG).show();
                    }
                });

                CategoryRes response1 = response.body();
                List<String> category = response1.getCat();

                String[] cat = category.toArray(new String[0]);

                mysp = findViewById(R.id.spn_type);
                ArrayAdapter<String> ad = new ArrayAdapter<>(NGOFilter.this, android.R.layout.simple_spinner_dropdown_item, cat);
                mysp.setAdapter(ad);
            }

            @Override
            public void onFailure(Call<CategoryRes> call, Throwable t) {
                Toast.makeText(NGOFilter.this, "Error Occurred", Toast.LENGTH_LONG).show();
            }
        });

        donate.setOnClickListener(v -> {
            Intent intent = new Intent(NGOFilter.this, SelectNGOActivity.class);
            intent.putExtra("type",mysp.getSelectedItem().toString());
            startActivity(intent);
        });
    }
}
