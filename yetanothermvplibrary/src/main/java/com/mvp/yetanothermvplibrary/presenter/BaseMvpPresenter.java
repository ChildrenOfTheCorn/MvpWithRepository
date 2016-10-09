package com.mvp.yetanothermvplibrary.presenter;

import com.mvp.yetanothermvplibrary.repository.MvpRepository;
import com.mvp.yetanothermvplibrary.view.MvpView;

import java.util.Set;

/**
 * Created by grishberg on 09.10.16.
 */
public abstract class BaseMvpPresenter<View extends MvpView, Repository extends MvpRepository> {
    private static final String TAG = BaseMvpPresenter.class.getSimpleName();
    private Repository repository;
    private View view;
    private Set<View> attachedVies;

    public View getView() {
        return this.view;
    }

    public Repository getRepository() {
        return this.repository;
    }

    public void attachView(View view) {

    }

    public void detachView(View view) {
    }

    public Set<View> getAttachedViews() {
        return this.attachedVies;
    }
}
