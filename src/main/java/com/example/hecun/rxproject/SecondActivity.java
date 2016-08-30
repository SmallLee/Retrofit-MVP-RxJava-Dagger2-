package com.example.hecun.rxproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import rx.Single;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //==============================================
//        Single.just("hello").subscribe(new SingleSubscriber<String>() {
//            @Override
//            public void onSuccess(String value) {
//
//            }
//            @Override
//            public void onError(Throwable error) {
//
//            }
//        });
        //=================================================
        //compose操作
//        Single.just("hello").compose(new Single.Transformer<String, String>() {
//            @Override
//            public Single<String> call(Single<String> stringSingle) {
//                return stringSingle.map(new Func1<String, String>() {
//                    @Override
//                    public String call(String s) {
//                        return "android";
//                    }
//                });
//            }
//        }).subscribe(new SingleSubscriber<String>() {
//            @Override
//            public void onSuccess(String value) {
//                Log.d(TAG, "onSuccess: "+value);
//            }
//
//            @Override
//            public void onError(Throwable error) {
//
//            }
//        });
        //====================================
        //flatMap和compose的区别，
//      Single.just("hello").flatMap(new Func1<String, Single<String>>() {
//          @Override
//          public Single<String> call(String s) {
//              return Single.just(s);
//          }
//      }).subscribe(new Action1<String>() {
//          @Override
//          public void call(String s) {
//
//          }
//      });
        //====================================
        Single<String> hello = Single.just("hello");
        Single<String> android = Single.just("android");

//      Single.concat(hello,android).subscribe(new Action1<String>() {
//          @Override
//          public void call(String s) {
//              Log.d(TAG, "call: "+s);//hello,android
//          }
//      });
        //====================================================
//        Single.create(new Single.OnSubscribe<String>() {
//            @Override
//            public void call(SingleSubscriber<? super String> singleSubscriber) {
//                singleSubscriber.onSuccess("hello");
//                singleSubscriber.onError(new NullPointerException("控制针"));
//            }
//        }).subscribe(new SingleSubscriber<String>() {
//            @Override
//            public void onSuccess(String value) {
//                Log.d(TAG, "onSuccess: "+value);//hello
//            }
//            @Override
//            public void onError(Throwable error) {
//                Log.d(TAG, "onError: "+error);
//            }
//        });
        //==========================================
        //just不能指定被观察者所在的线程，只能在当前线程
//        Single.just("d").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//
//                    }
//                });
        //===================================
        //error,返回一个立即给订阅者发射错误通知的Single，一般用于调试，不常用
//       Single.error(new RuntimeException("error"))
//              .subscribe(new Action1<Object>() {
//                  @Override
//                  public void call(Object o) {
//
//                  }
//              }, new Action1<Throwable>() {
//                  @Override
//                  public void call(Throwable throwable) {
//                      Log.d(TAG, "call: "+throwable);
//                  }
//              });
        //=======================================
        //flatMapObservable,将single转化为Observable对象
//        Single.just(2).flatMapObservable(new Func1<Integer, Observable<String>>() {
//            @Override
//            public Observable<String> call(Integer integer) {
//                return Observable.just("a","b","c");
//            }
//        }).subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//                Log.d(TAG, "onCompleted: ");
//            }
//            @Override
//            public void onError(Throwable e) {
//            }
//            @Override
//            public void onNext(String s) {
//                Log.d(TAG, "onNext: "+s);//a,b,c
//            }
//        });
        //=================================
        //merge和concat的结果是一样的，区别在于merge无顺序，concat可以保证顺序
//        Single.merge(hello,android).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.d(TAG, "call: "+s);//hello,android
//            }
//        });
        //===========================================================
        //zip,将多个Single整合为一个
//        Single.zip(hello, android, new Func2<String, String, String>() {
//            @Override
//            public String call(String s, String s2) {
//                return s+","+s2;
//            }
//        }).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.d(TAG, "call: "+s);//hello,android
//            }
//        });
        //============================================================
        

    }

}
