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

public class NewcollectionActivity extends Activity implements View.OnClickListener{

    @BindView(R.id.ncname_edit)
    EditText ncname_edit;
    @BindView(R.id.ncaddress_edit)
    EditText ncaddress_edit;
    @BindView(R.id.nccontact_edit)
    EditText ncncontact_edit;
    @BindView(R.id.weight_edit)
    EditText weight_edit;
    @BindView(R.id.catagory_edit)
    EditText catagory_edit;
    @BindView(R.id.more_edit)
    EditText more_edit;

    @BindView(R.id.ncdonebtn)
    Button ncdonebtn;

    String name,contact,address,weight,catagory,moreedit;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newcollection);
        ButterKnife.bind(this);
        ncdonebtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        if(v.getId()==R.id.ncdonebtn){
            done();
        }

    }


    private void done()
    {
        name=ncname_edit.getText().toString();
        address=ncaddress_edit.getText().toString();
        contact=ncncontact_edit.getText().toString();
        weight=weight_edit.getText().toString();
        catagory=catagory_edit.getText().toString();
        moreedit=more_edit.getText().toString();
        String er_name = Validator.nameValid(name);
        String er_address=Validator.addressValid(address);
        String er_contact=Validator.mobileValid(contact);
        String er_weight=Validator.weightValid(weight);
        String er_catagory=Validator.catagoryValid(catagory);
        String er_moreedit=Validator.moreeditValid(moreedit);
        if(er_name!=null){
            ncname_edit.setError(er_name);
        }
        else if(er_address!=null){
            ncaddress_edit.setError(er_address);
        }
        else if(er_contact!=null){
            ncncontact_edit.setError(er_contact);
        }
        if(er_weight!=null){
            weight_edit.setError(er_weight);
        }
        if(er_catagory!=null){
            catagory_edit.setError(er_catagory);
        }
        if(er_moreedit!=null){
            more_edit.setError(er_moreedit);
        }
        else {

            ncname_edit.setError(null);
            ncaddress_edit.setError(null);
            ncncontact_edit.setError(null);
            weight_edit.setError(null);
            catagory_edit.setError(null);
            more_edit.setError(null);
            Toast.makeText(this, "done Success", Toast.LENGTH_LONG).show();
        }


    }

}
