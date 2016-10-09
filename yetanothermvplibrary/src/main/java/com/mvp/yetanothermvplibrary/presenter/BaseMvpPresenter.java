package com.mvp.yetanothermvplibrary.presenter;

import com.mvp.yetanothermvplibrary.repository.MvpRepository;
import com.mvp.yetanothermvplibrary.view.MvpView;

import java.util.Set;

/**
 * Created by grishberg on 09.10.16.
 */
public abstract class BaseMvpPresenter<View extends MvpView, Repository extends MvpRepository> implements MvpPresenter<View> {
    private static final String TAG = BaseMvpPresenter.class.getSimpleName();
    private Repository repository;
    // ссылка на вью
    private View view;
    // ссылка на ViewState, TODO: должен генерироваться и уметь сохранять команды
    private View viewState;
    private Set<View> attachedVies;

    public View getView() {
        if (view == null) {
            // если вью отсоединилась, вернуть ViewState который должен сохранять команды
            // для отправки View, когда та снова приатачится
            return viewState;
        }
        return this.view;
    }

    public Repository getRepository() {
        return this.repository;
    }

    @Override
    public void attachView(final View view) {
        this.view = view;
        //TODO: пройтись по списку команд для данной вью и выполнить их
    }

    @Override
    public void detachView(final View view) {
        this.view = null;
    }

    public Set<View> getAttachedViews() {
        return this.attachedVies;
    }
}
