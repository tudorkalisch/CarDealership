package com.accenture.tudorckalisch.cardealership;

import android.app.DownloadManager;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by tudor.c.kalisch on 6/30/2017.
 */

public class MainActivity extends FragmentActivity implements Navigator {
    public static final String TAG = MainActivity.class.getSimpleName();
    private int positionFragment = 1;
    OkHttpClient client = new OkHttpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: MainActivity Created");
        String url = "http://www.mocky.io/v2/5959ea460f000097009fe235";
        OkHttpHandler okHttpHandler = new OkHttpHandler(new OkHttpHandler.AsyncResponse() {
            @Override
            public void processFinish(String output) {
                Gson gson = new Gson();
                Log.d(TAG, "processFinish: " + output);
                Car[] cars = gson.fromJson(output, Car[].class);
                navListFragment(cars);
            }
        });
        okHttpHandler.execute(url);
    }

    @Override
    public void navListFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        Fragment recycle = new ListFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
 //       Bundle args = new Bundle();
 //       args.putParcelableArray("cars",cars);
        fragmentTransaction.replace(R.id.main_layout,recycle).commit();
        positionFragment = 1;
    }

    @Override
    public void navListFragment(Car[] cars) {
        FragmentManager fragmentManager = getFragmentManager();
        Fragment recycle = new ListFragment();
        Bundle args = new Bundle();
        List<Car> carsArray = new ArrayList<>();
        Collections.addAll(carsArray, cars);
        Log.d(TAG, "navListFragment: " + cars[0].toString());
        args.putParcelableArrayList("cars",(ArrayList) carsArray);
        recycle.setArguments(args);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_layout,recycle).commitAllowingStateLoss();
        positionFragment = 1;
    }

    @Override
    public void navDetailsFragment(Car car) {
        FragmentManager fragmentManager = getFragmentManager();
        Fragment details = new DetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable("car", car);
        details.setArguments(args);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.main_layout, details).commit();
        positionFragment = 2;
    }
    @Override
    public void onBackPressed() {
        if(positionFragment == 1){
            finish();
        }
        if (positionFragment == 2) {
            FragmentManager fm = getFragmentManager();
            if (fm.getBackStackEntryCount() > 0) {
                Log.i("MainActivity", "popping backstack");
                fm.popBackStack();
            } else {
                Log.i("MainActivity", "nothing on backstack, calling super");
                super.onBackPressed();
            }
        }
    }
}
