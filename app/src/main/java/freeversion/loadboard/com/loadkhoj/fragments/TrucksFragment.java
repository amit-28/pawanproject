package freeversion.loadboard.com.loadkhoj.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import freeversion.loadboard.com.loadkhoj.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrucksFragment extends Fragment {


    public TrucksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trucks, container, false);
    }


}
