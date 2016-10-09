package com.mvp.mvptemplateproject.repository;

import com.mvp.mvptemplateproject.model.ExampleModel;
import com.mvp.yetanothermvplibrary.repository.MvpRepository;

import rx.Observable;

/**
 * Created by grishberg on 09.10.16.
 */
public interface ExampleRepository extends MvpRepository {
    Observable<ExampleModel> getDataFromRestServer(int id);
}
