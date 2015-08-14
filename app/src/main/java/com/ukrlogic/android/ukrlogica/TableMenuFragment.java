package com.ukrlogic.android.ukrlogica;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by root on 05.08.15.
 */
public class TableMenuFragment extends Fragment {
    String TITLES[] = {"Home","Events","Mail","Shop","Travel","Home","Events","Mail","Shop","Travel"};

    RecyclerView mRecyclerView;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager

    private final String MOBILE = "mobile";
    private final String DESIGN = "design";
    private final String MARKETING = "marketing";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.application_form_table, null);

        String msg = getArguments().getString("table");

        if (msg.equals(MOBILE)){
            TITLES = getResources().getStringArray(R.array.tableMobile);
        }
        else if (msg.equals(DESIGN)){
            TITLES = getResources().getStringArray(R.array.tableDesign);
        }
        else if (msg.equals(MARKETING)){
            TITLES = getResources().getStringArray(R.array.tableMarketing);
        }

        mRecyclerView = (RecyclerView)v.findViewById(R.id.RecyclerView); // Assigning the RecyclerView Object to the xml View
        mRecyclerView.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size

        mAdapter = new TableAdapter(TITLES);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)
        // And passing the titles,icons,header view name, header view email,
        // and header view profile picture
        mRecyclerView.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView
        mLayoutManager = new LinearLayoutManager(this.getActivity());                 // Creating a layout Manager
        mRecyclerView.setLayoutManager(mLayoutManager);                 // Setting the layout Manager
        return v;
    }
}
