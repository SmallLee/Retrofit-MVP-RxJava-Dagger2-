package com.example.hecun.rxproject.mvp.model.service;

import com.example.hecun.rxproject.common.Constant;
import com.example.hecun.rxproject.entity.MovieInfo;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * 访问完整url的Service
 */
public interface CommonService {
     String BASE_URL = Constant.FULL_URL;
    @GET
    Observable<MovieInfo> getMovieInfo(@Url String url);
}
