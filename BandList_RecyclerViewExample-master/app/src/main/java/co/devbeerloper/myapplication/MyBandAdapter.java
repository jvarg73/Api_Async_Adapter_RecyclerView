package co.devbeerloper.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import model.Band;

public class MyBandAdapter extends RecyclerView.Adapter <BandViewHolder> {

    private ArrayList<Band> bandsList;

    /**
     * Constructor of the adapter class
     * @param bandsList
     */
    public MyBandAdapter(ArrayList<Band> bandsList) {
        this.bandsList = bandsList;
    }


    @NonNull
    @Override
    public BandViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.band_custom_layout, viewGroup, false);

        BandViewHolder bandViewHolder = new BandViewHolder(contactView);

        return bandViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BandViewHolder viewHolder, int i) {
        //Band(String name, String height, String mass, String hair_color, String skin_color, String birth_year)

        Band bandTmp = bandsList.get(i);

        TextView nameTv = viewHolder.name;
        nameTv.setText(bandTmp.getName());

        TextView heightTv = viewHolder.heigh;
        heightTv .setText(bandTmp.getHeight());

        TextView massTv = viewHolder.mass;
        massTv.setText(bandTmp.getMass());

        TextView hair_colorTv = viewHolder.hair_c;
        hair_colorTv.setText(bandTmp.getHair_color());

        TextView skin_colorTv = viewHolder.skin_c;
        skin_colorTv.setText(bandTmp.getSkin_color());

        TextView birth_yearTv = viewHolder.birth_y;
        birth_yearTv.setText(bandTmp.getBirth_year());
    }

    @Override
    public int getItemCount() {
        return bandsList.size();
    }
}
