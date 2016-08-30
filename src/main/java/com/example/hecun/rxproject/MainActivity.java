package com.example.hecun.rxproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView textView;
    String[] datas = {"a","b","c"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
        ImageView imageview = new ImageView(this);
//        List<String> list = Arrays.asList(datas);
//        //调用Obsevable的静态方法create创建Observable对象
//        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("你好");
//            }
//        });
//        //创建Subscriber对象，实现三个方法
//       Subscriber<String> subscriber = new Subscriber<String>() {
//           @Override
//           public void onCompleted() {
//           }
//           @Override
//           public void onError(Throwable e) {
//           }
//           @Override
//           public void onNext(String s) {
//            textView.setText(s.toString());
//           }
//       };
//        //订阅
//        observable.subscribe(subscriber);
        //==========================================
//        Observable<String> observable = Observable.just("你好","不是","不知道");//只接收最后一个
//        observable.subscribe(new Action1<String>() {//对应onNext
//            @Override
//            public void call(String s) {
//                textView.setText(s.toString());//不知道
//            }
//        }, new Action1<Throwable>() {//对应onError
//            @Override
//            public void call(Throwable throwable) {
//
//            }
//        }, new Action0() {//对应onCompelete
//            @Override
//            public void call() {
//                Toast.makeText(MainActivity.this, "oncompelete", Toast.LENGTH_SHORT).show();
//            }
//        });
        //==============================================================
//        Observable.just("hello").map(new Func1<String, String>() {
//            @Override
//            public String call(String s) {
//                return "hello android";
//            }
//        }).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                textView.setText(s.toString());//hello android
//            }
//        });
//=============================================================
//        Observable.just("10").map(new Func1<String, Integer>() {
//            @Override
//            public Integer call(String s) {
//                return Integer.parseInt(s);
//            }
//        }).subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer integer) {
//                textView.setText(String.valueOf(integer));
//            }
//        });
        //=====================================================
//        Observable.from(datas).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.d(TAG, "call: "+s);//a,b,c
//            }
//        });
        //==============================================
//      Observable.from(datas).flatMap(new Func1<String, Observable<String>>() {
//          @Override
//          public Observable<String> call(String s) {
//              return null;
//          }
//      }).subscribe(new Action1<String>() {
//          @Override
//          public void call(String s) {
//
//          }
//      });
        //=================================
        //过滤
//        Observable.from(datas).filter(new Func1<String, Boolean>() {
//            @Override
//            public Boolean call(String s) {
//                return s.equals("a");//过滤掉不满足条件的
//            }
//        }).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.d(TAG, "call: "+s);//a
//            }
//        });
    //======================================================
//        Observable.from(datas).take(2).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.d(TAG, "call: "+s);//a,b.只取两个
//            }
//        });
        //========================================
//        //doOnext,每次输出之前做一些处理，执行在onNext方法之前
//        Observable.from(datas).doOnNext(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.d(TAG, "doonext: "+s);
//            }
//        }).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.d(TAG, "thread: "+Thread.currentThread().getName());//main
//                Log.d(TAG, "onnext: "+s);
//            }
//        });
        //===============================================
//        Observable.just("android").map(new Func1<String, String>() {
//            @Override
//            public String call(String s) {
//                if(s.equals("android")){//此处故意抛出一个异常
//                    throw new RuntimeException("无网络");
//                }
//                return s;
//            }
//        }).subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//                Log.d(TAG, "onCompleted: ");
//            }
//            @Override
//            public void onError(Throwable e) {//执行了onError方法
//                Log.d(TAG, "onError: "+e.getMessage());//无网络
//            }
//            @Override
//            public void onNext(String s) {
//                Log.d(TAG, "thread: "+Thread.currentThread().getName());
//                Log.d(TAG, "onNext: "+s);
//            }
//        });
        //===================================================
        //zip操作符,将两个结果一起发出，两个结果全部返回后才处理
        // 注意，zip操作父会导致观察者发生在子线程，如果
        //需要更新UI,此时我们需要切换到主线程，使用observeOn方法来指定
//        Observable<String> ob1 = Observable.just("10");
//        //故意在此延迟2秒，造成两个数据处理时间的差异
//        Observable<String> ob2 = Observable.just("20").delay(2, TimeUnit.SECONDS);
//        Observable.zip(ob1, ob2, new Func2<String, String, Integer>() {
//            @Override
//            public Integer call(String s, String s2) {
//                Log.d(TAG, "call: zip");
//                return Integer.parseInt(s)+Integer.parseInt(s2);
//            }
//        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer integer) {
//                Log.d(TAG, "thread: "+Thread.currentThread().getName());//RxComputationScheduler-1
//                textView.setText(String.valueOf(integer));
//            }
//        });
        //======================================================
        //在configuration改变（比如转屏）之后继续之前的Subscription。
//        Observable<String> request = Observable.just("请求数据").cache();
//        Subscription subscription = request.subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                //处理结果
//            }
//        });
//        //Activity销毁
//        subscription.unsubscribe();;//取消订阅
//        //Activity重建,重新请求
//        request.subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//
//            }
//        });
        //===========================================
        //concat,不交错的连接多个Observable的数据
//        Observable.concat(Observable.just("a"),Observable.just("b"),Observable.just("c"))
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        Log.d(TAG, "call: "+s);//a,b,c
//                    }
//                });
        //==========================================
        //first,发射第一个数据,first(),输出a,b,c,a
//        Observable.concat(Observable.just("a"),Observable.just("b"),Observable.just("b"))
//                .first(new Func1<String, Boolean>() {
//                    @Override
//                    public Boolean call(String s) {
//                        return s.equals("b");//只输出符合条件的第一个数据
//                    }
//                })
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        Log.d(TAG, "call: "+s);//b
//                    }
//                });
        //================================================
        //interval,每隔固定时间触发一次
//        Observable.just("请求数据").interval(3, TimeUnit.SECONDS)
//                .map(new Func1<Long, String>() {
//                    @Override
//                    public String call(Long aLong) {
//                        Log.d(TAG, "call: "+aLong);
//                        return String.valueOf(aLong);
//                    }
//                }).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
////                Log.d(TAG, "call: "+s);
//            }
//        });
        //=========================================================
        //错误处理,利用Exceptions.propagate(e)转化
//        Observable.just("hello").map(new Func1<String, String>() {
//            @Override
//            public String call(String s) {
//                try {
//                    return transform();//人为制造一个异常
//                } catch (ArithmeticException e) {
//                    //将checked异常转化为uncheckedi异常，并且床底给onErro
//                    throw Exceptions.propagate(e);
//                }
//            }
//        }).subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//                Log.d(TAG, "onCompleted: ");
//            }
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "onError: "+3);
//                Toast.makeText(MainActivity.this, "e:" + e, Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onNext(String s) {
//                Log.d(TAG, "onNext: "+s);
//
//            }
//        });
        //==========================================================
//        Observable.just("hello").flatMap(new Func1<String, Observable<String>>() {
//            @Override
//            public Observable<String> call(String s) {
//                try {
//                    return Observable.just(transform());
//                } catch (ArithmeticException e) {
//                    //如果返回值类型是Observable，则可以使用Observable.error(e)
//                    return Observable.error(e);
//                }
//            }
//        }).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//
//            }
//        }, new Action1<Throwable>() {
//            @Override
//            public void call(Throwable throwable) {
//                Toast.makeText(MainActivity.this, "toast"+throwable, Toast.LENGTH_SHORT).show();
//            }
//        });
        //================================================
        //onErrorReturn,发生错误时不走onError，执行onNext方法，可以指定一个发生错误时的值
//        Observable.just("hello").map(new Func1<String, String>() {
//            @Override
//            public String call(String s) {
//                return transform();
//            }
//        }).onErrorReturn(new Func1<Throwable, String>() {
//            @Override
//            public String call(Throwable throwable) {
//                return "error";
//            }
//        }).subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//            }
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "onError: ");
//            }
//            @Override
//            public void onNext(String s) {
//                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
//            }
//        });
        //==================================================
//        Observable.just("hello").map(new Func1<String, String>() {
//            @Override
//            public String call(String s) {
//                return transform();
//            }
//        }).onErrorResumeNext(new Func1<Throwable, Observable<? extends String>>() {
//            @Override
//            public Observable<? extends String> call(Throwable throwable) {
//                return Observable.just("error");
//            }
//        }).subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//            }
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "onError: ");
//            }
//            @Override
//            public void onNext(String s) {
//                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
//            }
//        });
    }



    public String transform() throws ArithmeticException{
        return 1/0+"";
    }

    public void single(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
    public void subject(View view){
        Intent intent = new Intent(this,SubjectActivity.class);
        startActivity(intent);
    }

    public void Schedulers(View view){
        Intent intent = new Intent(this,SchedulersActivity.class);
        startActivity(intent);
    }
    public void Demo(View view){
        Intent intent = new Intent(this,DemoActivity.class);
        startActivity(intent);
    }

    public void emptyView(View view){
       startActivity(new Intent(this,EmptyActivity.class));
    }

}
