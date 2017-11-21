package com.accenture.tudorckalisch.cardealership;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

import okhttp3.OkHttpClient;

/**
 * Created by tudor.c.kalisch on 6/30/2017.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    List<Car> list = Collections.emptyList();
    private CarSelectionListener listener;
    RecycleViewAdapter(List<Car> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate layout, initialize  View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //Use the provieded View Holder on the oncreateViewHolder method to popup
        holder.name.setText(list.get(position).name);
        holder.type.setText(list.get(position).type);
        holder.description.setText(list.get(position).description);
        Glide.with(holder.imageView.getContext())
                .load(list.get(position).imageId)
                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onCarSelected(list.get(holder.getAdapterPosition()));
                }
            }
        });

        //animate(holder);
    }

    @Override
    public int getItemCount() {
        //return the number of elements the RecyclerView will display
        return (list == null ? 0 : list.size());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void setCarSelectionListener(CarSelectionListener listener) {
        this.listener = listener;
    }

    public interface CarSelectionListener {
        void onCarSelected(Car car);
    }
}
