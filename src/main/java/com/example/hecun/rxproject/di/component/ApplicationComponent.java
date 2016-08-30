package com.example.hecun.rxproject.di.component;

import android.content.Context;

import com.example.hecun.rxproject.di.module.ApplicationModule;
import com.example.hecun.rxproject.di.scope.ContextLife;
import com.example.hecun.rxproject.mvp.model.ServiceFactory;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2016/8/19.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    @ContextLife("Application")
    Context getApplicationContext();
    ServiceFactory getServiceFactory();
}
