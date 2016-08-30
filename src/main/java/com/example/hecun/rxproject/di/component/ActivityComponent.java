package com.example.hecun.rxproject.di.component;

import android.content.Context;

import com.example.hecun.rxproject.DemoActivity;
import com.example.hecun.rxproject.di.module.ActivityModule;
import com.example.hecun.rxproject.di.scope.ActivityScope;
import com.example.hecun.rxproject.di.scope.ContextLife;

import dagger.Component;

/**
 * Created by Administrator on 2016/8/19.
 */
@ActivityScope//注意，此处不能使用Single注解，否则编译出错
@Component(dependencies = ApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {
//    @ContextLife("Activity")
//    Context getContext();

    @ContextLife("Application")
    Context getApplicationContext();
    //定义对象

    //需要此对象的Activity，注入
    void inject(DemoActivity demoActivity);
}
