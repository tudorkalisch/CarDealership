package com.accenture.tudorckalisch.cardealership;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static android.R.id.list;


public class DetailsFragment extends Fragment {
    public static final String TAG = DetailsFragment.class.getSimpleName();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_details, container, false);
        Bundle args = getArguments();
        if (args != null) {
            Car car = args.getParcelable("car");
            TextView name = v.findViewById(R.id.details_name);
            name.setText(car.getName());
            TextView type = v.findViewById(R.id.details_type);
            type.setText(car.getType());
            TextView description = v.findViewById(R.id.details_description);
            description.setText(car.getDescription());
            ImageView imageView = v.findViewById(R.id.details_image);
            Glide.with(getContext())
                    .load(car.getImageId())
                    .into(imageView);
            return v;
        } else {
            Log.d(TAG, "onCreateView: Can't get args");
            return v;
        }
    }
}
