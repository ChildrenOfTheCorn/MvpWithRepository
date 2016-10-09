package com.mvp.mvptemplateproject.presenter;

import com.mvp.mvptemplateproject.model.ExampleModel;
import com.mvp.yetanothermvplibrary.presenter.MvpPresenter;
import com.mvp.yetanothermvplibrary.view.MvpView;

import rx.Observable;

/**
 * Created by grishberg on 09.10.16.
 */
public interface ExamplePresenter<View extends MvpView> extends MvpPresenter<View> {
    Observable<ExampleModel> getData(int id);
}
