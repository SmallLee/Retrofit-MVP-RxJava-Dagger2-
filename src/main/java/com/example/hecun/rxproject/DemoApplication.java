package com.example.hecun.rxproject;

import android.app.Application;

import com.example.hecun.rxproject.di.component.ApplicationComponent;
import com.example.hecun.rxproject.di.component.DaggerApplicationComponent;
import com.example.hecun.rxproject.di.module.ApplicationModule;

/**
 * Created by hecun on 2016/8/19.
 */
public class DemoApplication extends Application{
    private ApplicationComponent mApplicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder().
                applicationModule(new ApplicationModule(this)).
                build();
    }

    public ApplicationComponent getApplicationComponent(){
        return mApplicationComponent;
    }
}
