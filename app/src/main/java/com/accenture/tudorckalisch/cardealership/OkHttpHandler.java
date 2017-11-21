package com.accenture.tudorckalisch.cardealership;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by tudor.c.kalisch on 6/30/2017.
 */

public class OkHttpHandler extends AsyncTask<String, Void, String> {
    public interface AsyncResponse {
        void processFinish(String output);
    }

    AsyncResponse delegate = null;
    OkHttpClient client = new OkHttpClient();
    public static final String TAG = OkHttpHandler.class.getSimpleName();

    public OkHttpHandler(AsyncResponse delegate){
        this.delegate = delegate;
    }
    @Override
    protected String doInBackground(String... params) {

        Request.Builder builder = new Request.Builder();
        builder.url(params[0]);
        Request request = builder.build();

        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //Nu se poate returna lista de cars in post execute, declara o interfata in MainActivity de tip onRecievedCars(callback) prin
    //care o sa returnezi lista de cars
    @Override
    protected void onPostExecute(String s) {
    delegate.processFinish(s);
   }

}
