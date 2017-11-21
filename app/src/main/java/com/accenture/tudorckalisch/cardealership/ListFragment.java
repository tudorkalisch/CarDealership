package com.accenture.tudorckalisch.cardealership;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tudor.c.kalisch on 6/30/2017.
 */

public class ListFragment extends Fragment {
    public static final String TAG = ListFragment.class.getSimpleName();

    public List<Car> fill_with_data() {
        List<Car> data = new ArrayList<>();

        data.add(new Car("Name1", "Type1", "Description1 Description1 Description1 Description1 Description1 ", "Image1"));
        data.add(new Car("Name2", "Type2", "Description2 Description2 Description2 Description2 Description2 ", "Image2"));
        data.add(new Car("Name3", "Type3", "Description3 Description3 Description3 Description3 Description3 ", "Image3"));
        data.add(new Car("Name4", "Type4", "Description4 Description4 Description4 Description4 Description4 ", "Image4"));
        data.add(new Car("Name5", "Type5", "Description5 Description5 Description5 Description5 Description5 ", "Image5"));

        return data;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //List<Car> list = fill_with_data();
        List<Car> list = getArguments().getParcelableArrayList("cars");
        View v = inflater.inflate(R.layout.fragment_recycleview, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.cardview_container);

        LinearLayoutManager llManager = new LinearLayoutManager(inflater.getContext());
        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llManager);

        Log.d(TAG, "onCreateView: setAdapter " + getContext());
        RecycleViewAdapter adapter = new RecycleViewAdapter(list);
        Log.d(TAG, "onCreateView: Adapter: " + adapter);
        recyclerView.setAdapter(adapter);
        adapter.setCarSelectionListener(new RecycleViewAdapter.CarSelectionListener() {
            @Override
            public void onCarSelected(Car car) {
                Activity activity = getActivity();
                if(activity instanceof MainActivity){
                    ((MainActivity) activity)
                            .navDetailsFragment(car);
                }
            }
        });
        return v;


    }

}
