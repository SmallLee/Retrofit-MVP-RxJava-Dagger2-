package com.example.hecun.rxproject.di.module;

import android.content.Context;

import com.example.hecun.rxproject.DemoApplication;
import com.example.hecun.rxproject.di.scope.ContextLife;
import com.example.hecun.rxproject.mvp.model.ServiceFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/8/19.
 */
@Module
public class ApplicationModule {
    public DemoApplication mDemoApplication;

    public ApplicationModule(DemoApplication demoApplication){
        this.mDemoApplication = demoApplication;
    }

    @Singleton
    @Provides
    @ContextLife("Application")
    public Context provideApplicationContext(){
        return mDemoApplication;
    }

    //...............下面是其他的提供对象的方法
    @Provides
    public ServiceFactory provideServiceFactory(){
        return ServiceFactory.getInstance(mDemoApplication);
    }
}
