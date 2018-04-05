package com.shyamanu.merakicard.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shyamanu.merakicard.R;
import com.shyamanu.merakicard.adapter.MasonryAdapter;
import com.shyamanu.merakicard.customviews.SpacesItemDecoration;

/**
 * Created by shwettank.ramteke on 3/29/2018.
 */

public class MyProductFragment  extends Fragment {


    String LOG_TAG = "MyProductFragment";
    /* [Main root view for xml inflation] */
    private View fRootView = null;
    private LayoutInflater fLayoutInflater = null;
    Toolbar mToolbar;
    RecyclerView mRecyclerView;

    public MyProductFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    //    return inflater.inflate(R.layout.fragment_my_product, container, false);

        try {
            if (fRootView == null) {
                fRootView = inflater.inflate(R.layout.fragment_my_product, container, false);
                fLayoutInflater = inflater;
            }
        } catch (Exception e) {
            Log.e(LOG_TAG, "Exception Inflating layout" + e.getMessage());
        }


        mRecyclerView = (RecyclerView) fRootView.findViewById(R.id.masonry_grid);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        MasonryAdapter adapter = new MasonryAdapter(this);
        mRecyclerView.setAdapter(adapter);
        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        mRecyclerView.addItemDecoration(decoration);

        return fRootView;
    }
}
