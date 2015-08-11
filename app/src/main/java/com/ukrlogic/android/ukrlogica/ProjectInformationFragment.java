package com.ukrlogic.android.ukrlogica;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by root on 06.08.15.
 */
public class ProjectInformationFragment extends Fragment {
    String TITLES[] = {"Home","Events","Mail","Shop","Travel","Home","Events","Mail","Shop","Travel"};

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.project_inform_list, null);

        mRecyclerView = (RecyclerView)v.findViewById(R.id.RecyclerView);

        mAdapter = new ProjectInformationAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        return v;
    }

}
