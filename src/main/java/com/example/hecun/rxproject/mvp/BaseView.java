package com.example.hecun.rxproject.mvp;

import com.example.hecun.rxproject.mvp.model.HttpResult;

/**
 * Created by hecun on 2016/8/19.
 */
public interface BaseView<T extends HttpResult> {
    void showView(T result);
    void showError(Throwable throwable);
}
