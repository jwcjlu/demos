package com.jwcjlu.demos.rxJava;

import io.reactivex.*;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.io.IOException;
import java.util.concurrent.Executors;

public class ObservableTest {
    public static void main(String[] args) throws IOException {
        Scheduler  scheduler= Schedulers.from(Executors.newCachedThreadPool());

        Observable.create(new ObservableOnSubscribe<Integer>() { // 第一步：初始化Observable
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                System.out.println(Thread.currentThread().getName()+" Observable emit 1" + "\n");
                e.onNext(1);
                System.out.println(Thread.currentThread().getName()+" Observable emit 2" + "\n");
                e.onNext(2);
                System.out.println(Thread.currentThread().getName()+" Observable emit 3" + "\n");
                e.onNext(3);
                e.onComplete();
                System.out.println(Thread.currentThread().getName()+" Observable emit 4" + "\n");
                e.onNext(4);

            }
        }).observeOn(scheduler).map((i)->{
            System.out.println(Thread.currentThread().getName()+i);
            return i+1;
        })
                .observeOn(scheduler).subscribe(new Observer<Integer>() { // 第三步：订阅

            // 第二步：初始化Observer
            private int i;
            private Disposable mDisposable;

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mDisposable = d;
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                i++;
                if (i == 2) {
                    // 在RxJava 2.x 中，新增的Disposable可以做到切断的操作，让Observer观察者不再接收上游事件
                    mDisposable.dispose();
                }
                System.out.println(Thread.currentThread().getName()+" onNext : value : " + integer + "\n");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError : value : " + e.getMessage() + "\n");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete" + "\n");
            }
        });
        System.in.read();
    }
}
