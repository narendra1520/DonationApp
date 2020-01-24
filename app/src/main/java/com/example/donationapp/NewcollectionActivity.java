package com.example.donationapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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
    @BindView(R.id.more_edit)
    EditText more_edit;

    @BindView(R.id.spn_type)
    Spinner mysp;
    @BindView(R.id.spn_cate)
    Spinner mysp1;

    @BindView(R.id.ncdonebtn)
    Button ncdonebtn;

    String[] type_arr={"h","g"}, cate_arr={"h","k"};

    String name,contact,address,weight,catagory,moreedit;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newcollection);
        ButterKnife.bind(this);
        ncdonebtn.setOnClickListener(this);

        ArrayAdapter<String> ad= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, type_arr);
        mysp.setAdapter(ad);

        ArrayAdapter<String> ad1= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, cate_arr);
        mysp1.setAdapter(ad1);
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
        moreedit=more_edit.getText().toString();
        String er_name = Validator.nameValid(name);
        String er_address=Validator.addressValid(address);
        String er_contact=Validator.mobileValid(contact);
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
        if(er_moreedit!=null){
            more_edit.setError(er_moreedit);
        }
        else {

            ncname_edit.setError(null);
            ncaddress_edit.setError(null);
            ncncontact_edit.setError(null);
            more_edit.setError(null);
            Toast.makeText(this, "done Success", Toast.LENGTH_LONG).show();
        }


    }

}
