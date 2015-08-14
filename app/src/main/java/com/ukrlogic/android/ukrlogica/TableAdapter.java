package com.ukrlogic.android.ukrlogica;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by root on 05.08.15.
 */
public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder>  {
    private final static String TAG = "logs";

    private static final int TYPE_HEADER = 0;  // Declaring Variable to Understand which View is being worked on
    // IF the view under inflation and population is header or Item
    private static final int TYPE_ITEM = 1;

    private String mNavTitles[]; // String Array to store the passed titles Value from MainActivity.java

    private String name;        //String Resource for header View Name
    private int profile;        //int Resource for header view profile picture
    private String email;       //String Resource for header view email


    // Creating a ViewHolder which extends the RecyclerView View Holder
    // ViewHolder are used to to store the inflated views in order to recycle them

    public static class ViewHolder extends RecyclerView.ViewHolder {
        int Holderid;

        TextView textView;


        public ViewHolder(View itemView,int ViewType) {      // Creating ViewHolder Constructor with View and viewType As a parameter
            super(itemView);


            // Here we set the appropriate view in accordance with the the view type as passed when the holder object is created

            if(ViewType == TYPE_ITEM) {
                Holderid = 1;       // setting holder id as 1 as the object being populated are of type item row
                textView = (TextView)itemView.findViewById(R.id.textView);
            }
            else{

                Holderid = 0;     // Setting holder id = 0 as the object being populated are of type header view
            }
        }


    }



    TableAdapter(String Titles[]){ // MyAdapter Constructor with titles and icons parameter
        // titles are passed from the main activity as we
        mNavTitles = Titles;                //have seen earlier


    }



    //Below first we ovverride the method onCreateViewHolder which is called when the ViewHolder is
    //Created, In this method we inflate the item_row.xml layout if the viewType is Type_ITEM or else we inflate header.xml
    // if the viewType is TYPE_HEADER
    // and pass it to the view holder

    @Override
    public TableAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.checkbox_row,parent,false); //Inflating the layout

            ViewHolder vhItem = new ViewHolder(v,viewType); //Creating ViewHolder and passing the object of type view

            return vhItem; // Returning the created object

            //inflate your layout and pass it to view holder


        }
        Log.d(TAG, "9 fragtag");
        return null;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textView.setText(mNavTitles[position]);
    }


    // This method returns the number of items present in the list
    @Override
    public int getItemCount() {
        return mNavTitles.length; // the number of items in the list will be +1 the titles including the header view.
    }


    // Witht the following method we check what type of view is being passed
    @Override
    public int getItemViewType(int position) {

        return TYPE_ITEM;

    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

}