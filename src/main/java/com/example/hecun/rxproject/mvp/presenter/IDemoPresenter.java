package com.example.hecun.rxproject.mvp.presenter;

import android.util.Log;

import com.example.hecun.rxproject.entity.MovieInfo;
import com.example.hecun.rxproject.mvp.BaseView;
import com.example.hecun.rxproject.mvp.model.service.MovieInfoService;
import com.example.hecun.rxproject.mvp.model.subscriber.HttpSubscriber;
import com.example.hecun.rxproject.mvp.view.BasePresenterImpl;
import com.example.hecun.rxproject.mvp.view.IDemoView;
import com.example.hecun.rxproject.util.TransformUtil;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import rx.Subscription;

/**
 * Presenter层，做具体的数据请求，然后回调给View层，需要继承BasePresenterImpl
 */
public class IDemoPresenter extends BasePresenterImpl {
    private static final String TAG = "IDemoPresenter";
    IDemoView demoView;
    @Inject
    public IDemoPresenter(){
        Log.d(TAG, "IDemoPresenter: 调用了");
    }

    @Override
    public void attachView(BaseView view) {
        demoView = (IDemoView) view;
    }

    public void getMovieInfo(String sortBy,String apiKey){
       Subscription subscription = mServiceFactory
                .createService(MovieInfoService.class)
                .getMovieInfo(sortBy,apiKey)
                .compose(TransformUtil.<MovieInfo>defaultTransform())
                .subscribe(new HttpSubscriber<MovieInfo>() {
                    @Override
                    public void onSuccess(MovieInfo movieInfo) {
                        Logger.d(movieInfo.toString());
                        demoView.showView(movieInfo);
                    }
                    @Override
                    public void _onError(Throwable throwable) {
                        Logger.d(throwable.getMessage());
                        demoView.showError(throwable);
                    }
                });
        addSubscription(subscription);
    }
}
