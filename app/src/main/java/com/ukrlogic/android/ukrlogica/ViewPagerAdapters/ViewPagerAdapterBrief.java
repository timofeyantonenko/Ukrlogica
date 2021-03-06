package com.ukrlogic.android.ukrlogica.ViewPagerAdapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.ukrlogic.android.ukrlogica.TableMenuFragment;

/**
 * Created by root on 08.08.15.
 */
public class ViewPagerAdapterBrief extends ViewPagerAdapter {
    Bundle args;

    private final String MOBILE = "mobile";
    private final String DESIGN = "design";
    private final String MARKETING = "marketing";

    public ViewPagerAdapterBrief(FragmentManager fm, CharSequence[] mTitles, int mNumbOfTabsumb) {
        super(fm, mTitles, mNumbOfTabsumb);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) // if the position is 0 we are returning the First tab
        {
            TableMenuFragment tableMenuFragment = new TableMenuFragment();
            args = new Bundle();
            args.putString("table", MOBILE);
            tableMenuFragment.setArguments(args);
            return tableMenuFragment;
        }
        else if (position ==1)          // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            TableMenuFragment tableMenuFragment = new TableMenuFragment();
            args = new Bundle();
            args.putString("table", DESIGN);
            tableMenuFragment.setArguments(args);
            return tableMenuFragment;
        }
        else
        {
            TableMenuFragment tableMenuFragment = new TableMenuFragment();
            args = new Bundle();
            args.putString("table", MARKETING);
            tableMenuFragment.setArguments(args);
            return tableMenuFragment;
        }
    }
}
