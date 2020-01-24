package com.example.donationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DonateActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.dname_edit)
    EditText dname_edit;
    @BindView(R.id.demail_edit)
    EditText demail_edit;
    @BindView(R.id.damount_rs)
    EditText damount_edit;
    @BindView(R.id.donebtn)
    Button donebtn;

    String email,name,amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        ButterKnife.bind(this);
        donebtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.donebtn) {
            done();
        }
    }

    private void done()
    {
        name=dname_edit.getText().toString();
        email = demail_edit.getText().toString();
        amount = damount_edit.getText().toString();
        String er_name = Validator.nameValid(name);
        String er_email = Validator.emialValid(email);
        String er_amount = Validator.amountValid(amount);

        if(er_email!=null){
            demail_edit.setError(er_email);
        }else if (er_name!=null){
            dname_edit.setError(er_name);
        }else if(er_amount!=null){
            damount_edit.setError(er_amount);
        }else{
            //loginn retrofit
            demail_edit.setError(null);
            damount_edit.setError(null);
            dname_edit.setError(null);
            Toast.makeText(this,"Donation Success",Toast.LENGTH_LONG).show();
        }
    }
}
