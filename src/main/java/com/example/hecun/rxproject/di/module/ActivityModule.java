package com.example.hecun.rxproject.di.module;

import android.app.Activity;

import dagger.Module;

/**
 * Created by Administrator on 2016/8/19.
 */
@Module
public class ActivityModule {
    Activity mActivity;
    public ActivityModule(Activity activity){
        this.mActivity = activity;
    }

//    @Provides
//    @ActivityScope
//    @ContextLife("Activity")
//    public Context provideContext(){
//        return mActivity;
//    }
}
