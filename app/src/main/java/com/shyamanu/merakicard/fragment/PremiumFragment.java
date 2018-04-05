package com.shyamanu.merakicard.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shyamanu.merakicard.R;

/**
 * Created by shwettank.ramteke on 3/29/2018.
 */

public class PremiumFragment extends Fragment {
    public PremiumFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_premium, container, false);
    }
}
