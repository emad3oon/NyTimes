package com.example.nytimes.connection;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.nytimes.R;
import com.google.gson.Gson;

import retrofit2.Response;


/**
 * Authored by Mohamed Fathy on 22 Nov, 2017.
 * Contact: m.fathy@aymax.com
 * Logistics by Aymax.net © 2017.
 * <p>
 * <p>
 * Validate response body
 */

@SuppressWarnings("WeakerAccess")
public class Validator {

    private Context context;
    private Services.OnResponseReceived responseReceived;

    public Validator(Context context, Services.OnResponseReceived responseReceived) {
        this.context = context;
        this.responseReceived = responseReceived;
    }

    /**
     * Validate response body to check if it's error or not
     *
     * @param response body
     * @param flag     name of the service
     */
    @SuppressLint("CheckResult")
    public void validateResponse(Response<?> response, String flag) {
        if (response != null) {
            Log.d(APIUrls.FLAGS.FULL_API_URL, response.raw().request().url().toString());
            Log.d(APIUrls.FLAGS.REQUES_API, new Gson().toJson(response.body()));
            if (response.isSuccessful()) {
                responseReceived.onResponse(true, flag, response.body());
                Log.d("response success", new Gson().toJson(response.body()));
            } else {
                switch (response.code()) {
                    default:
                        Toast.makeText(context, context.getString(R.string.server_error), Toast.LENGTH_SHORT).show();
                        Log.d("response default", new Gson().toJson(response.body()));
                        break;
                    case 400:
                    case 401:

                        break;
                    case 500:
                        Toast.makeText(context, context.getString(R.string.server_error), Toast.LENGTH_SHORT).show();
                        Log.d("response 500", new Gson().toJson(response.body()));
                        break;
                    case 404:
                        break;
                }
            }
        } else {
            Toast.makeText(context, context.getString(R.string.server_error), Toast.LENGTH_SHORT).show();
        }
    }
}
