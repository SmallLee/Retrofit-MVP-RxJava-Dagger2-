package com.example.hecun.rxproject.mvp.model.service;

import com.example.hecun.rxproject.common.Constant;
import com.example.hecun.rxproject.entity.MovieInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 普通Service
 */
public interface MovieInfoService {
    @GET(Constant.BASE_URL)
    Observable<MovieInfo> getMovieInfo(@Query("sort_by") String sort_by,@Query("api_key") String api_key);
}
