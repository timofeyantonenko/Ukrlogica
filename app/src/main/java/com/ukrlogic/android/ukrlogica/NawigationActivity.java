package com.ukrlogic.android.ukrlogica;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

/**
 * Created by root on 04.08.15.
 */
public class NawigationActivity extends ActionBarActivity implements View.OnClickListener{
    private final static String TAG = "logs";
    private String[] mPlanetTitles = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};
    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;   // Declaring the Toolbar Object
    private ActionBarDrawerToggle mDrawerToggle;
    String TITLES[] = {"Presentation","Brief","Works","Brandbook"};
    private ListView mDrawerList;

    RecyclerView mRecyclerView;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager

    FragmentManager fragmentManager;

    private boolean isDrawerOpen = false;

    ImageButton mainHome;

    Context context;

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.nawigation_activity);
        fragmentManager = getSupportFragmentManager();

        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);   // Setting toolbar as the ActionBar with setSupportActionBar() call
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mainHome = (ImageButton)toolbar.findViewById(R.id.main_home);
        mainHome.setOnClickListener(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView); // Assigning the RecyclerView Object to the xml View
        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        switch (position) {
                            case 0: {
                                finish();
                                overridePendingTransition(R.anim.left_in, R.anim.right_out);
                                break;
                            }
                            case 1: {
                                Fragment fragment = new PresentationFragment();
                                loadFragment(fragment);
                                mDrawerLayout.closeDrawer(Gravity.LEFT);
                                    break;
                            }case 2: {
                                Bundle bundle = new Bundle();
                                bundle.putString("adapter", "brief");
                                Fragment fragment = new GeneralSlideFragment();
                                fragment.setArguments(bundle);
                                loadFragment(fragment);
                                mDrawerLayout.closeDrawer(Gravity.START);
                                break;
                            }
                            case 3: {
                                Bundle bundle = new Bundle();
                                bundle.putString("adapter", "works");
                                Fragment fragment = new GeneralSlideFragment();
                                fragment.setArguments(bundle);
                                loadFragment(fragment);
                                mDrawerLayout.closeDrawer(Gravity.LEFT);
                                break;
                            }
                            case 4: {
                                Bundle bundle = new Bundle();
                                bundle.putString("adapter", "brandbook");
                                Fragment fragment = new GeneralSlideFragment();
                                fragment.setArguments(bundle);
                                loadFragment(fragment);
                                mDrawerLayout.closeDrawer(Gravity.LEFT);
                                break;
                            }
                        }
                    }
                })
        );

        mRecyclerView.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size

        mAdapter = new MyAdapter(TITLES);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)
        // And passing the titles,icons,header view name, header view email,
        // and header view profile picture
        mRecyclerView.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView

        mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager

        mRecyclerView.setLayoutManager(mLayoutManager);                 // Setting the layout Manager



        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        Intent intent = getIntent();
        String  loadedFragment = intent.getStringExtra("fragment");
        Log.d(TAG, "String is "+ loadedFragment);

        // Insert the fragment by replacing any existing fragment

        if(loadedFragment.equals("menu")) {
            Fragment fragment = new PresentationFragment();
            loadFragment(fragment);
        }
        if(loadedFragment.equals("table")) {
            Bundle bundle = new Bundle();
            bundle.putString("adapter", "brief");
            Fragment fragment = new GeneralSlideFragment();
            fragment.setArguments(bundle);
            loadFragment(fragment);
        }
        if(loadedFragment.equals("projects")) {
            Bundle bundle = new Bundle();
            bundle.putString("adapter", "works");
            Fragment fragment = new GeneralSlideFragment();
            fragment.setArguments(bundle);
            loadFragment(fragment);
        }
        if(loadedFragment.equals("brandbook")) {
            Bundle bundle = new Bundle();
            bundle.putString("adapter", "works");
            Fragment fragment = new SendFormFragment();
            fragment.setArguments(bundle);
            loadFragment(fragment);
        }
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                if(slideOffset > .55 && !isDrawerOpen){
                    onDrawerOpened(drawerView);
                    isDrawerOpen = true;
                } else if(slideOffset < .45 && isDrawerOpen) {
                    onDrawerClosed(drawerView);
                    isDrawerOpen = false;
                }
            }
        }; // Drawer Toggle Object Made

        mDrawerLayout.setDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
        mDrawerToggle.syncState();               // Finally we set the drawer toggle sync State




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_home:
            finish();
                overridePendingTransition(R.anim.left_in, R.anim.right_out);
                break;

        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        // Create a new fragment and specify the planet to show based on position
        Fragment fragment = new PresentationFragment();
        Bundle args = new Bundle();
        args.putInt("number", position);
        fragment.setArguments(args);

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();

        // Highlight the selected item, update the title, and close the drawer
        mDrawerList.setItemChecked(position, true);
        setTitle(mPlanetTitles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_user) {
            finish();
            overridePendingTransition(R.anim.left_in, R.anim.right_out);
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }


        private void loadFragment(Fragment fragment){
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();

        }



}
