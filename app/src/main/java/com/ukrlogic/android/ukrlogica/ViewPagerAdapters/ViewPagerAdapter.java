package com.ukrlogic.android.ukrlogica.ViewPagerAdapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ukrlogic.android.ukrlogica.ProjectsListFragment;

/**
 * Created by root on 08.08.15.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created
    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }
    @Override
    public Fragment getItem(int position) {
        if(position == 0) // if the position is 0 we are returning the First tab
        {
            ProjectsListFragment projectsListFragment = new ProjectsListFragment();
            return projectsListFragment;
        }
        else if (position ==1)          // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            ProjectsListFragment projectsListFragment = new ProjectsListFragment();
            return projectsListFragment;
        }
        else
        {
            ProjectsListFragment projectsListFragment = new ProjectsListFragment();
            return projectsListFragment;
        }

    }
    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    @Override
    public int getCount() {
        return NumbOfTabs;
    }


}

