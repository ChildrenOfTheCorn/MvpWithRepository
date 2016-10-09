package com.mvp.mvptemplateproject.repository;

import com.mvp.mvptemplateproject.model.ExampleModel;
import com.mvp.mvptemplateproject.model.rest.ApiService1;
import com.mvp.mvptemplateproject.model.rest.ApiService2;
import com.mvp.yetanothermvplibrary.repository.BaseMvpRepository;

import javax.inject.Inject;

import rx.Observable;

public class MyRepositoryService extends BaseMvpRepository implements ExampleRepository {
    public MyRepositoryService() {
    }

    @Inject
    ApiService1 api1;
    ApiService2 api2;

    @Override
    public Observable<ExampleModel> getDataFromRestServer(final int id) {
        return Observable.create(subscriber -> {
            subscriber.onNext(api1.getData(id));
            subscriber.onCompleted();
        });
    }
}
