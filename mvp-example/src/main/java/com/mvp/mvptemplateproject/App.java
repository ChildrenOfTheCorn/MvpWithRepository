package com.mvp.mvptemplateproject;

import android.app.Application;

import com.mvp.mvptemplateproject.injection.AppComponent;
import com.mvp.mvptemplateproject.injection.AppModule;
import com.mvp.mvptemplateproject.injection.DaggerAppComponent;
import com.mvp.mvptemplateproject.injection.PresentersModule;
import com.mvp.mvptemplateproject.injection.RestModule;
import com.mvp.mvptemplateproject.model.ApiConst;

/**
 * Created by grishberg on 09.10.16.
 */
public class App extends Application {
    private static final String TAG = App.class.getSimpleName();

    protected static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initComponents(DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .restModule(new RestModule(ApiConst.END_POINT))
                .presentersModule(new PresentersModule())
                .build());
    }

    public void initComponents(AppComponent appComponent) {
        App.appComponent = appComponent;
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
