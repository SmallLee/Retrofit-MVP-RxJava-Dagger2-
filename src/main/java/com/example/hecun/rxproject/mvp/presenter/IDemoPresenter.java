package com.example.hecun.rxproject.mvp.presenter;

import com.example.hecun.rxproject.mvp.BasePresenter;

/**
 *
 */
public interface IDemoPresenter extends BasePresenter {
    //特有的操作
    void getMovieInfo(String sortBy,String apiKey);
}
