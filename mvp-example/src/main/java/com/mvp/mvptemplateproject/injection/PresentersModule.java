package com.mvp.mvptemplateproject.injection;

import com.mvp.mvptemplateproject.presenter.ExamplePresenter;
import com.mvp.mvptemplateproject.presenter.ExamplePresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by grishberg on 09.10.16.
 */
@Module
public class PresentersModule {
    private static final String TAG = PresentersModule.class.getSimpleName();

    @Singleton
    @Provides
    public ExamplePresenter provideSExamplePresenter() {
        return new ExamplePresenterImpl();
    }
}
