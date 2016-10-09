package com.mvp.yetanothermvplibrary.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mvp.yetanothermvplibrary.presenter.MvpPresenter;

/**
 * Created by grishberg on 09.10.16.
 */
public abstract class BaseMvpActivity<Presenter extends MvpPresenter> extends AppCompatActivity implements MvpView {
    private static final String TAG = BaseMvpActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        getPresenter().detachView(this);
    }

    protected abstract Presenter getPresenter();

    protected abstract void inject();
}
