package com.example.nytimes.connection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Authored by Emad Mohamed on 26 May , 2018.
 * Contact: emad.3oon@gmail.com
 * Aziz by Phorous.com © 2018.
 */

public class RetroConnect {

    public static Retrofit getRetrofitInstance() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        return new Retrofit.Builder()
                .baseUrl(APIUrls.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(getClient())
                .build();
    }


    private static OkHttpClient getClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(2, TimeUnit.MINUTES);
        builder.writeTimeout(2, TimeUnit.MINUTES);

        builder.addInterceptor(logging);

        return builder.build();
    }

}
