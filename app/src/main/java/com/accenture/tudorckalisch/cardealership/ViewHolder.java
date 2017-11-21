package com.accenture.tudorckalisch.cardealership;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class ViewHolder extends RecyclerView.ViewHolder {

    public CardView cv;
    public TextView name;
    public TextView type;
    public TextView description;
    public ImageView imageView;

    ViewHolder(View itemView) {
        super(itemView);
        CardView cv = itemView.findViewById(R.id.cardView);
        name = itemView.findViewById(R.id.row_car_name);
        type = itemView.findViewById(R.id.row_car_type);
        description = itemView.findViewById(R.id.row_car_description);
        imageView = itemView.findViewById(R.id.row_car_image);
    }

}
