package com.example.hecun.rxproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import rx.functions.Action1;
import rx.subjects.PublishSubject;
import rx.subjects.ReplaySubject;

/**
 * AsyncSubject
 * BehaviorSubject
 * PublishSubject
 * ReplaySubject
 */
public class SubjectActivity extends AppCompatActivity {
    private static final String TAG = "SubjectActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        test();
    }

    public void test(){
        //AsyncSubject,简单的说使用AsyncSubject无论输入多少参数，永远只输出最后一个参数。
        //也就是onCompleted方法之前的哪一个
//        AsyncSubject<String> asyncSubject = AsyncSubject.create();
//        asyncSubject.onNext("a");
//        asyncSubject.onNext("b");
//        asyncSubject.onNext("c");
//        asyncSubject.subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.d(TAG, "call: "+s);//c
//            }
//        });
//        asyncSubject.onCompleted();//必须调用，否则无输出
        //================================================
//         BehaviorSubject会发送离订阅最近的上一个值以及下面的值，没有上一个值的时候会发送默认值。
//        BehaviorSubject<String> objectBehaviorSubject = BehaviorSubject.create();
//        objectBehaviorSubject.onNext("a");
//        objectBehaviorSubject.onNext("b");
//        objectBehaviorSubject.subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.d(TAG, "call: "+s);//b,c
//            }
//        }) ;
//        objectBehaviorSubject.onNext("c");
//        objectBehaviorSubject.onCompleted();
//=====================================================
        //PublishSubject,可以说是最正常的Subject，从那里订阅就从那里开始发送数据
        PublishSubject<String> publishSubject = PublishSubject.create();
        publishSubject.onNext("a");
        //这里订阅打印b,c
        publishSubject.onNext("b");
        //这里订阅打印
        publishSubject.onNext("c");
        //这里订阅什么都不输出
        publishSubject.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, "call: "+s);
            }
        });
        publishSubject.onCompleted();
        //=========================================
        //ReplaySubject,都会将所有历史订阅内容全部发出。
        ReplaySubject<String> replaySubject = ReplaySubject.create();
        replaySubject.onNext("a");
        replaySubject.onNext("b");
        replaySubject.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, "call: "+s);//a,b,c
            }
        });
        replaySubject.onNext("c");
        replaySubject.onCompleted();

    }
}


