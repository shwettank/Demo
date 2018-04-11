package com.shyamanu.merakicard.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shyamanu.merakicard.R;

/**
 * Created by shwettank.ramteke on 4/11/2018.
 */

public class AddProductActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtCategory = null;
    private EditText edtCompany = null;
    private EditText edtProductName = null;
    private Button btnAdd = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_products);

        //initialize components
        initView();

        // add listener
        addListener();

    }

    private void initView() {
        edtCategory = (EditText) findViewById(R.id.editTextCategory);
        edtCompany = (EditText) findViewById(R.id.editTextCompany);
        edtProductName = (EditText) findViewById(R.id.editTextProduct);
        btnAdd = (Button) findViewById(R.id.buttonAddProduct);
    }


    private void addListener() {
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonAddProduct:
                Toast.makeText(getApplicationContext(),"Product Added",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
