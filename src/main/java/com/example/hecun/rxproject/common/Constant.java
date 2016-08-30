package com.example.hecun.rxproject.common;

/**
 * 常量
 */
public interface Constant {
    String API_KEY = "643e503c35816202926457ad7d535052";
    String BASE_URL = "http://api.themoviedb.org/3/discover/movie/";
    String SCORE_LIST = "?sort_by=vote_average.desc";
    String POP_LIST = "?sort_by=popularity.desc";
    String IMAGE_URL = "http://image.tmdb.org/t/p/w185";
    String DESC = "popularity.desc";
    String VOTE = "vote_average.desc";
    String FULL_URL = "http://api.themoviedb.org/3/discover/movie/?sort_by=popularity.desc&api_key=643e503c35816202926457ad7d535052";
}
