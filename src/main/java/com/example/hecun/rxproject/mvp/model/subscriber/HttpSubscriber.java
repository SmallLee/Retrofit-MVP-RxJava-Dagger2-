package com.example.hecun.rxproject.mvp.model.subscriber;

import rx.Subscriber;

/**
 * 自定义全局Subscriber，处理响应结果
 */
public abstract class HttpSubscriber<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        _onError(e);
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    public abstract void onSuccess(T t);
    public abstract void _onError(Throwable throwable);
}
