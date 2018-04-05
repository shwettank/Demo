package com.shyamanu.merakicard.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.shyamanu.merakicard.R;


/**
 * Created by shwettank.ramteke on 3/26/2018.
 */

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtCountryCode = null;
    private EditText edtMobileNumber = null;
    private EditText edtPassword = null;
    private EditText edtConfirmPassword = null;
    private EditText edtAreaCode = null;
    private Button btnSubmit = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registration);

      //initialize components
        initView();
      
      // add listener
        addListener();
    }


    /**
     *  initialize components
     */
    private void initView() {
        edtCountryCode = (EditText) findViewById(R.id.editTextCountryCode);
        edtMobileNumber = (EditText) findViewById(R.id.editTextMobileNo);
        edtPassword = (EditText) findViewById(R.id.editTextPassword);
        edtConfirmPassword = (EditText) findViewById(R.id.editTextConfirmPassword);
        edtAreaCode = (EditText) findViewById(R.id.editTextAreaCode);
        btnSubmit = (Button) findViewById(R.id.buttonSubmit);
    }


    private void addListener() {
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.buttonSubmit:
                Intent intentTabView = new Intent(RegistrationActivity.this,TabActivity.class);
                startActivity(intentTabView);
                break;

            default:
                break;
        }
    }
}
