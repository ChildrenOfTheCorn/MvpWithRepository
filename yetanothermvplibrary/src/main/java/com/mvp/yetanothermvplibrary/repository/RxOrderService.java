package com.mvp.yetanothermvplibrary.repository;

import com.mvp.yetanothermvplibrary.presenter.MvpPresenter;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by grishberg on 09.10.16.
 * Данный класс нужно генерировать
 */
public class RxOrderService implements MvpRepository {
    private static final String TAG = RxOrderService.class.getSimpleName();
    private final CompositeSubscription compositeSubscription;

    public RxOrderService(CompositeSubscription compositeSubscription) {
        this.compositeSubscription = compositeSubscription;
    }
}
