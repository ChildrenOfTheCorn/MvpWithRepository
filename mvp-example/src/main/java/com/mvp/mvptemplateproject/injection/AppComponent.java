package com.mvp.mvptemplateproject.injection;

import com.mvp.mvptemplateproject.ui.activities.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by grishberg on 09.10.16.
 */
@Singleton
@Component(modules = {RestModule.class, AppModule.class, PresentersModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}