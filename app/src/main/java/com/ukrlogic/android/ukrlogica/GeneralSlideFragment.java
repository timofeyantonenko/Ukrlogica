package com.ukrlogic.android.ukrlogica;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ukrlogic.android.ukrlogica.ViewPagerAdapters.ViewPagerAdapter;
import com.ukrlogic.android.ukrlogica.ViewPagerAdapters.ViewPagerAdapterBrandBook;
import com.ukrlogic.android.ukrlogica.ViewPagerAdapters.ViewPagerAdapterBrief;
import com.ukrlogic.android.ukrlogica.ViewPagerAdapters.ViewPagerAdapterProjects;
import com.ukrlogic.android.ukrlogica.tabs.SlidingTabLayout;

/**
 * Created by root on 07.08.15.
 */
public class GeneralSlideFragment extends Fragment {
    private static final String TAG = "logs";


    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[];
    int Numboftabs =3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //set tge layout for fragment
        View v = inflater.inflate(R.layout.mob_des_mar_slider,null);
// Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        String adaptersKey = getArguments().getString("adapter");
        if(adaptersKey.equals("works")) {
            Titles = getResources().getStringArray(R.array.works_tabs);
            adapter = new ViewPagerAdapterProjects(this.getChildFragmentManager(), Titles, Numboftabs);
        }
        else if(adaptersKey.equals("brief")){
            Titles = getResources().getStringArray(R.array.brief_tabs);
            adapter = new ViewPagerAdapterBrief(this.getChildFragmentManager(), Titles, Numboftabs);
        }
        else if(adaptersKey.equals("brandbook")){
            Titles = getResources().getStringArray(R.array.brandbook_tabs);
            adapter = new ViewPagerAdapterBrandBook(this.getChildFragmentManager(), Titles, Numboftabs);
        }

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) v.findViewById(R.id.pager);
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(3);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) v.findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);


        return v;
    }
}
