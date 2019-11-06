package co.devbeerloper.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Holder of the view
 */
public class BandViewHolder extends RecyclerView.ViewHolder  {
    //Band(String name, String height, String mass, String hair_color, String skin_color, String birth_year)

    public TextView name;
    public TextView heigh;
    public TextView mass;
    public TextView hair_c;
    public TextView skin_c;
    public TextView birth_y;


    public BandViewHolder(View bandView) {
        super(bandView);

        this.name = (TextView) itemView.findViewById(R.id.NameTx);;
        this.heigh = (TextView) itemView.findViewById(R.id.HeightTx);
        this.mass = (TextView) itemView.findViewById(R.id.MassTx);
        this.hair_c = (TextView) itemView.findViewById(R.id.Hair_colorTx);
        this.skin_c = (TextView) itemView.findViewById(R.id.Skin_colorTx);
        this.birth_y = (TextView) itemView.findViewById(R.id.Birth_yearTx);
    }


}
