package com.shyamanu.merakicard.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.shyamanu.merakicard.R;
import com.shyamanu.merakicard.adapter.CustomGrid;

/**
 * Created by shwettank.ramteke on 4/11/2018.
 */

public class CategoryActivity extends AppCompatActivity {

    GridView grid;
    String[] web = {
            "Mobile",
            "Fridge",
            "AC",
            "Bike",
            "Car"

    } ;
    int[] imageId = {
            R.drawable.ic_search_black_24dp,
            R.drawable.ic_search_black_24dp,
            R.drawable.ic_search_black_24dp,
            R.drawable.ic_search_black_24dp,
            R.drawable.ic_search_black_24dp

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);

        CustomGrid adapter = new CustomGrid(CategoryActivity.this, web, imageId);
        grid=(GridView)findViewById(R.id.gridViewCategory);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(CategoryActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });
    }
}
