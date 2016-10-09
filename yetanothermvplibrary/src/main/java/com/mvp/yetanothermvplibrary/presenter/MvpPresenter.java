package com.mvp.yetanothermvplibrary.presenter;

import com.mvp.yetanothermvplibrary.view.MvpView;

/**
 * Created by grishberg on 09.10.16.
 */
public interface MvpPresenter<View extends MvpView> {
    void attachView(View view);

    void detachView(View view);
}
