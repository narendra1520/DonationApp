package com.example.donationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForgotpasswordActivity extends Activity implements View.OnClickListener {

    @BindView(R.id.femail_edit)
    EditText femail_edit;
    String email;
    @BindView(R.id.sendbtn)
    Button sendbtn;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        ButterKnife.bind(this);
        sendbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.sendbtn) {
            send();
        }

    }

    private void send()
    {
        email=femail_edit.getText().toString();
        String er_email = Validator.emialValid(email);
        if(er_email!=null){
            femail_edit.setError(er_email);
        }
        else {
            //loginn retrofit
            femail_edit.setError(null);
            Toast.makeText(this, "send Success", Toast.LENGTH_LONG).show();
        }


    }

}
