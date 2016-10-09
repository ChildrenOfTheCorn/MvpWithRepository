package com.mvp.mvptemplateproject.common;

import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by grishberg on 09.10.16.
 */
public class RxUtils {
    private static final String TAG = RxUtils.class.getSimpleName();

    public static <T> Observable<T> wrapAsync(Observable<T> observable) {
        return wrapAsync(observable, Schedulers.io());
    }

    /**
     * Указать что выполнение будет в новом потоке, результат - в главном
     * @param observable
     * @param scheduler
     * @param <T>
     * @return
     */
    public static <T> Observable<T> wrapAsync(Observable<T> observable, Scheduler scheduler) {
        return observable
                .materialize()
                .subscribeOn(scheduler)
                .observeOn(AndroidSchedulers.mainThread()).<T>dematerialize();
    }

    public static <T> Observable<T> wrapMessage(T message) {
        return Observable.create(subscriber -> {
            subscriber.onNext(message);
            subscriber.onCompleted();
        });
    }
}
