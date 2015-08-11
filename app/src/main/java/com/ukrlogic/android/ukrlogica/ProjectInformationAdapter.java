package com.ukrlogic.android.ukrlogica;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 06.08.15.
 */
public class ProjectInformationAdapter extends RecyclerView.Adapter<ProjectInformationAdapter.ViewHolder>  {
    private final static String TAG = "logs";

    List<EndangeredItem> mItems;

    public ProjectInformationAdapter() {
        super();
        mItems = new ArrayList<EndangeredItem>();
        EndangeredItem species = new EndangeredItem();
        species.setName("Amur Leopard");
        species.setThumbnail(R.drawable.ic_action_cloud);
        mItems.add(species);

        species = new EndangeredItem();
        species.setName("Black Rhino");
        species.setThumbnail(R.drawable.user1);
        mItems.add(species);

        species = new EndangeredItem();
        species.setName("Orangutan");
        species.setThumbnail(R.drawable.user2);
        mItems.add(species);

        species = new EndangeredItem();
        species.setName("Sea Lions");
        species.setThumbnail(R.drawable.user2);
        mItems.add(species);

        species = new EndangeredItem();
        species.setName("Indian Elephant");
        species.setThumbnail(R.drawable.user1);
        mItems.add(species);

        species = new EndangeredItem();
        species.setName("Giant Panda");
        species.setThumbnail(R.drawable.user2);
        mItems.add(species);

        species = new EndangeredItem();
        species.setName("Snow Leopard");
        species.setThumbnail(R.drawable.user2);
        mItems.add(species);

        species = new EndangeredItem();
        species.setName("Dolphin");
        species.setThumbnail(R.drawable.user1);
        mItems.add(species);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.project_information_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        EndangeredItem nature = mItems.get(i);
        viewHolder.tvspecies.setText(nature.getName());
        viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());
    }

    @Override
    public int getItemCount() {

        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgThumbnail;
        public TextView tvspecies;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            tvspecies = (TextView)itemView.findViewById(R.id.tv_species);
        }
    }

}
