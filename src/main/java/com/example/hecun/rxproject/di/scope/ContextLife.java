package com.example.hecun.rxproject.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by Administrator on 2016/8/19.
 */
    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ContextLife {
    String value() default "Application";
}
