package com.mvp.yetanothermvplibrary.repository;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.mvp.yetanothermvplibrary.presenter.MvpPresenter;

/**
 * Created by grishberg on 09.10.16.
 * Базовый репозиторий, наследник Service
 * Во время атача устанавливается PresenterInterface, которому б
 */
public class BaseMvpRepository<PresenterInterface extends MvpPresenter> extends Service {
    private static final String TAG = BaseMvpRepository.class.getSimpleName();

    private PresenterInterface presenterInterface;

    // Binder given to clients
    private final IBinder binder = new LocalBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class LocalBinder extends Binder {
        BaseMvpRepository getService() {
            // Return this instance of LocalService so clients can call public methods
            return BaseMvpRepository.this;
        }
    }
}
