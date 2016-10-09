package com.mvp.mvptemplateproject.view;

import com.mvp.mvptemplateproject.model.ExampleModel;
import com.mvp.yetanothermvplibrary.view.MvpView;

/**
 * Created by grishberg on 09.10.16.
 */
public interface ExampleView extends MvpView {
    void onConnectionFail(String message);

    void onGetData(ExampleModel data);
}
