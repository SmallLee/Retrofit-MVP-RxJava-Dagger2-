package com.example.hecun.rxproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.subjects.PublishSubject;

public class SchedulersActivity extends AppCompatActivity {
    private static final String TAG = "SchedulersActivity";
    private Subscription sub;
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedulers);
        editText = (EditText) findViewById(R.id.et_content);
        textView = (TextView) findViewById(R.id.textview);
        test();
    }
    public void test(){
        //=================================
        //创建线程
//        Schedulers.newThread().createWorker().schedule(new Action0() {
//            @Override
//            public void call() {
//                Log.d(TAG, "call: "+Thread.currentThread().getName());// RxNewThreadScheduler-1
//            }
//        });
        //===============================
        //延迟3秒任务
//        Schedulers.newThread().createWorker().schedule(new Action0() {
//            @Override
//            public void call() {
//
//            }
//        },3, TimeUnit.SECONDS);
        //==============================================
        //每隔2秒执行任务
        // RxNewThreadScheduler-1
//        sub = Schedulers.newThread().createWorker().schedulePeriodically(new Action0() {
//            @Override
//            public void call() {
//                Log.d(TAG, "call: "+Thread.currentThread().getName());// RxNewThreadScheduler-1
//            }
//        },0,2, TimeUnit.SECONDS);
        //==================================
        //debunce，过滤掉发射速率比较快的消息
        //=========================================
        final PublishSubject<String> publishSubject = PublishSubject.create();
//     publishSubject.debounce(3,TimeUnit.SECONDS).
//             observeOn(AndroidSchedulers.mainThread()).
//             subscribe(new Action1<String>() {
//         @Override
//         public void call(String result) {
//             //文字变化3秒后才设置给textview
//             textView.setText(result);
//         }
//     });
        //=========================================
        //throttleWithTimeout,底层也是debounce
//        publishSubject.throttleWithTimeout(3, TimeUnit.SECONDS)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String result) {
//                        //文字变化3秒后才设置给textview
//                     textView.setText(result);
//                    }
//                });
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//            }
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                publishSubject.onNext(charSequence.toString());
//            }
//            @Override
//            public void afterTextChanged(Editable editable) {
//            }
//        });
        //====================================
        //lift操作，xJava 都不建议开发者自定义 Operator 来直接使用 lift()，而是建议尽量使用已有的 lift()
        // 包装方法（如 map() flatMap() 等）
        // 进行组合来实现需求，因为直接使用 lift() 非常容易发生一些难以发现的错误。
//        Observable<String> observable = Observable.just("10");
//        observable.lift(new Observable.Operator<Integer, String>() {
//            @Override
//            public Subscriber<? super String> call(Subscriber<? super Integer> subscriber) {
//                return new Subscriber<String>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//                    @Override
//                    public void onError(Throwable e) {
//                    }
//                    @Override
//                    public void onNext(String s) {
//                        Log.d(TAG, "onNext: "+s);
//                    }
//                };
//            }
//        });
        //==========================================================
        //doOnSubscribe和onStart都是在事件发送前调用，区别在于doOnSubscribe可以指定线程
        //下面代码的执行顺序是onStart,doOnSubscribe,onNext,onCompelete
        Observable.just("10").
                compose(new MyTransform())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        Log.d(TAG, "doOnSubscribe: "+Thread.currentThread().getName());
                    }
                })
//                .subscribeOn(Schedulers.io())//指定doOnSubscribe执行的线程
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        Log.d(TAG, "onStart: ");
                    }
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "onNext: ");
                    }
                });
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在Activity位于后台的情况下停止订阅
        sub.unsubscribe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 自定义转化类
     */
    //compose
    class MyTransform implements Observable.Transformer<String, Integer>{

        @Override
        public Observable<Integer> call(Observable<String> stringObservable) {
            return stringObservable.map(new Func1<String, Integer>() {
                @Override
                public Integer call(String s) {
                    return Integer.parseInt(s);
                }
            });
        }
    }
}
