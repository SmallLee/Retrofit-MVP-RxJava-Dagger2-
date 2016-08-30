package com.example.hecun.rxproject.mvp.model;

import android.content.Context;

import com.example.hecun.rxproject.common.Constant;
import com.example.hecun.rxproject.mvp.model.intercepter.CacheInterceptor;
import com.example.hecun.rxproject.mvp.model.intercepter.LoggingInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hecun on 2016/8/19.
 */
public class ServiceFactory {
    //定义全局的BASE_URL
    public static final String BASE_URL = Constant.BASE_URL;
    public static final long CACHE_SIZE = 10*1024*1024;
    private static Context mContext;
    private  Gson mGsonDataFormat;

    public ServiceFactory(){
        mGsonDataFormat = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    }

    public static class ServiceFactoryHolder{
        static ServiceFactory INSTANCE = new ServiceFactory();
    }
    public static ServiceFactory getInstance(Context context){
        mContext = context;
        return ServiceFactoryHolder.INSTANCE;
    }

    public <S> S createService(Class<S> serviceClass){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(mGsonDataFormat))
                .client(setOkHttpClient())
                .build();

        return retrofit.create(serviceClass);
    }

    public OkHttpClient setOkHttpClient(){
        File httpCacheDirectory = new File(mContext.getCacheDir(),"okhttpcache");
        return new OkHttpClient.Builder()
                .cache(new Cache(httpCacheDirectory,CACHE_SIZE))
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new LoggingInterceptor())
                .addInterceptor(new CacheInterceptor(mContext))
                .addNetworkInterceptor(new CacheInterceptor(mContext))
                .build();
    }
}
