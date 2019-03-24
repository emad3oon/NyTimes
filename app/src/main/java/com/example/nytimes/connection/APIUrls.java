package com.example.nytimes.connection;

/**
 * Authored by Emad Mohamed on 26 May , 2018.
 * Contact: emad.3oon@gmail.com
 * Aziz by Phorous.com © 2018.
 */

public class APIUrls {


    public static final String BASE_URL = "https://api.nytimes.com/svc/mostpopular/v2/";

    public class EndPoint {
        public static final String ENDPOINT_ARTICLES = "viewed/7.json";

    }

    public static class FLAGS {
        public static final String FLAG_ARTICLES_LIST = "articles_list";
        public static final String FULL_API_URL = "url";
        public static final String REQUES_API = "request";
        public static final String FLAG_SERVER_ERROR = "flag_error";
        public static final String FLAG_ARTICLE_DETAILS = "article_details";

    }
}
