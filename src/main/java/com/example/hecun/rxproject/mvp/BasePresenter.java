package com.example.hecun.rxproject.mvp;

/**
 * Created by hecun on 2016/8/19.
 */
public  interface BasePresenter<T extends BaseView> {
    //关联View,子类必须实现的方法
    void attachView(BaseView view);
    void detachView();
}
