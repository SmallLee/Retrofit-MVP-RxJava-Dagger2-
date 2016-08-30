package com.example.hecun.rxproject.mvp.view;

import com.example.hecun.rxproject.mvp.BasePresenter;
import com.example.hecun.rxproject.mvp.BaseView;
import com.example.hecun.rxproject.mvp.model.ServiceFactory;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by hecun on 2016/8/19.
 */
public  abstract class BasePresenterImpl implements BasePresenter<BaseView> {

    //使用CompositeSubscription来持有所有的Subscriptions，然后在onDestroy()或者onDestroyView()里取消所有的订阅。
    //防止内存泄漏
    private CompositeSubscription mCompositeSubscription;
    @Inject
    public ServiceFactory mServiceFactory;

    protected void addSubscription(Subscription s) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }
        this.mCompositeSubscription.add(s);
    }

    //关联View,子类必须实现的方法
    public abstract void attachView(BaseView view);

    @Override
    public void detachView() {
        if (this.mCompositeSubscription != null) {
            this.mCompositeSubscription.unsubscribe();
        }
    }
}
