package com.example.nytimes.connection;

import com.example.nytimes.models.ArticlesModel;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.nytimes.connection.APIUrls.EndPoint.ENDPOINT_ARTICLES;

/**
 * Authored by Emad Mohamed on 26 May , 2018.
 * Contact: emad.3oon@gmail.com
 * Aziz by Phorous.com © 2018.
 */

public interface APIService {

    @GET(ENDPOINT_ARTICLES)
    Observable<Response<ArticlesModel>> getArticlesList(@Query("api-key") String apiKey);
}
