package com.example.donationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends Activity implements View.OnClickListener {
    @BindView(R.id.rname_edit)
    EditText rname_edit;
    @BindView(R.id.remail_edit)
    EditText remail_edit;
    @BindView(R.id.rpass_edit)
    EditText rpass_edit;
    @BindView(R.id.rmobile_edit)
    EditText rmobile_edit;
    @BindView(R.id.registerbtn)
    Button registerbtn;
    @BindView(R.id.login_txt)
    Button login_txt;

    String email,pass,name,mobileno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        registerbtn.setOnClickListener(this);
        login_txt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.login_txt) {
            login();
        }
        else if(v.getId()==R.id.registerbtn){
            registration();
        }
    }



    private void registration()
    {
        name=rname_edit.getText().toString();
        email = remail_edit.getText().toString();
        pass = rpass_edit.getText().toString();
        mobileno=rmobile_edit.getText().toString();
        String er_name = Validator.nameValid(name);

        String er_email = Validator.emialValid(email);
        String er_pass = Validator.passValid(pass);
        String er_mobileno = Validator.mobileValid(mobileno);

        if(er_email!=null){
            remail_edit.setError(er_email);
        }else if (er_pass!=null){
            rpass_edit.setError(er_pass);
        }else if(er_name!=null){
            remail_edit.setError(er_name);
        }else if (er_mobileno!=null){
            rmobile_edit.setError(er_mobileno);}
        else{
            //loginn retrofit
            remail_edit.setError(null);
            rpass_edit.setError(null);
            rname_edit.setError(null);
            rmobile_edit.setError(null);
            Toast.makeText(this,"Registration Success",Toast.LENGTH_LONG).show();
        }

    }
    private void login() {

        Intent i= new Intent(RegisterActivity.this,MainActivity.class);
        startActivity(i);
    }



}

