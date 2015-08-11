package com.ukrlogic.android.ukrlogica;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by root on 06.08.15.
 */
public class ProjectsListFragment extends Fragment {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    //для работы с фрагментами
    FragmentTransaction fTrans;
    Fragment projectInformationFragment;
    Bundle args;

    String[] scrollImages = {"longer","longer","longer","longer","longer","longer","longer","longer" };

    private FragmentActivity myContext;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        myContext=(FragmentActivity) activity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_proects_gridview, null);

        // Calling the RecyclerView
        mRecyclerView = (RecyclerView)v.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        // The number of Columns
        mLayoutManager = new GridLayoutManager(this.getActivity(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ProjectsGridAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // do whatever
                        chooseProject(position);
                    }
                })
        );
        return v;
    }

    private void chooseProject(int position) {
        //projectInformationFragment = new ProjectInformationFragment();
        projectInformationFragment = new ScrollImageFragment();
        args = new Bundle();
        args.putString("scrollImage", scrollImages[position]);
        projectInformationFragment.setArguments(args);
        fTrans = getActivity().getSupportFragmentManager().beginTransaction();
        fTrans.replace(R.id.content_frame, projectInformationFragment);
        fTrans.addToBackStack(null);
        fTrans.commit();
    }


}
