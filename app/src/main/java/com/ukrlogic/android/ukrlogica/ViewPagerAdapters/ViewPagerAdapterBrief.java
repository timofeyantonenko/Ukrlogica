package com.ukrlogic.android.ukrlogica.ViewPagerAdapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.ukrlogic.android.ukrlogica.TableMenuFragment;

/**
 * Created by root on 08.08.15.
 */
public class ViewPagerAdapterBrief extends ViewPagerAdapter {
    public ViewPagerAdapterBrief(FragmentManager fm, CharSequence[] mTitles, int mNumbOfTabsumb) {
        super(fm, mTitles, mNumbOfTabsumb);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) // if the position is 0 we are returning the First tab
        {
            TableMenuFragment tableMenuFragment = new TableMenuFragment();
            return tableMenuFragment;
        }
        else if (position ==1)          // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            TableMenuFragment tableMenuFragment = new TableMenuFragment();
            return tableMenuFragment;
        }
        else
        {
            TableMenuFragment tableMenuFragment = new TableMenuFragment();
            return tableMenuFragment;
        }
    }
}
