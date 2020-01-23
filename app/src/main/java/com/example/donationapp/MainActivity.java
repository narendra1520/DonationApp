package com.example.donationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.email_edit)
    EditText email_edit;
    @BindView(R.id.pass_edit)
    EditText pass_edit;
    @BindView(R.id.loginbtn)
    Button loginbtn;
    String email,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loginbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.loginbtn){
            login();
        }
    }

    private void login() {
        email = email_edit.getText().toString();
        pass = pass_edit.getText().toString();

        String er_email = Validator.emialValid(email);
        String er_pass = Validator.passValid(pass);
        if(er_email!=null){
            email_edit.setError(er_email);
        }else if (er_pass!=null){
            pass_edit.setError(er_pass);
        }else{
            //loginn retrofit
            email_edit.setError(null);
            pass_edit.setError(null);
            Toast.makeText(this,"Login Success",Toast.LENGTH_LONG).show();
        }
    }


}

