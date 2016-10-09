package com.mvp.mvptemplateproject.injection;

import android.content.Context;
import android.content.res.Resources;

import com.mvp.mvptemplateproject.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by grishberg on 09.10.16.
 */
@Module
public class AppModule {
    private final App app;

    public AppModule(final App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return app.getApplicationContext();
    }

    @Provides
    @Singleton
    Resources provideResources() {
        return app.getResources();
    }
}
