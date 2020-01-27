package com.example.donationapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.donationapp.Api.RetrofitClient;
import com.example.donationapp.POJO.CollDetails;
import com.example.donationapp.POJO.CollDetailsRes;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CollDetailActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.map_btn)
    Button map_btn;
    @BindView(R.id.cal_btn)
    Button cal_btn;
    @BindView(R.id.point_txt)
    TextView point;
    @BindView(R.id.addr_txt)
    TextView addr;
    @BindView(R.id.email_txt)
    TextView email;
    @BindView(R.id.ctime_txt)
    TextView desc;
    @BindView(R.id.donate_txt)
    TextView total;

    CollDetails collDetails;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coll_detail);
        ButterKnife.bind(this);

        map_btn.setOnClickListener(this);
        cal_btn.setOnClickListener(this);

        //String tag = getIntent().getStringExtra("tag");
        String tag = "678";

        Call<CollDetailsRes> responseCall1 = RetrofitClient.getInstance()
                .getInterPreter().getCollDetails(tag);
        responseCall1.enqueue(new Callback<CollDetailsRes>() {
            @Override
            public void onResponse(Call<CollDetailsRes> call, Response<CollDetailsRes> response) {
                CollDetailsRes response1 = response.body();
                collDetails = response1.getCollDetails();
                point.setText(collDetails.getName());
                addr.setText(collDetails.getAddress());
                email.setText(collDetails.getEmail());
                total.setText(collDetails.getToatl_donation());
            }

            @Override
            public void onFailure(Call<CollDetailsRes> call, Throwable t) {
                Toast.makeText(CollDetailActivity.this, "Error Occurred", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.map_btn) {
            String uri = collDetails.getGmap();
            if(uri.equals("none")){
                Toast.makeText(this,"NO Map data found", Toast.LENGTH_SHORT).show();
            }
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(uri));
            startActivity(intent);
        }
        else if(v.getId()==R.id.cal_btn){
            String uri = "+91"+collDetails.getContact();
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(uri));
            startActivity(intent);
        }
    }
}
