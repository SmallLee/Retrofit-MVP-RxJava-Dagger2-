package com.example.hecun.rxproject.mvp;

/**
 * Created by hecun on 2016/8/19.
 */
public  interface BasePresenter<T extends BaseView> {
    void detachView();
}
