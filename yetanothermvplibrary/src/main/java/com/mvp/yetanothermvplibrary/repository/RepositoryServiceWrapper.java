package com.mvp.yetanothermvplibrary.repository;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by grishberg on 09.10.16.
 * Данный класс нужно генерировать
 */
public class RepositoryServiceWrapper implements MvpRepository {
    private static final String TAG = RepositoryServiceWrapper.class.getSimpleName();
    private final CompositeSubscription compositeSubscription;

    public RepositoryServiceWrapper(CompositeSubscription compositeSubscription) {
        this.compositeSubscription = compositeSubscription;
    }
}
