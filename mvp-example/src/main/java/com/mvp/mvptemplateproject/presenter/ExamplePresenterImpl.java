package com.mvp.mvptemplateproject.presenter;

import android.util.Log;

import com.mvp.mvptemplateproject.common.RxUtils;
import com.mvp.mvptemplateproject.model.ExampleModel;
import com.mvp.mvptemplateproject.repository.ExampleRepository;
import com.mvp.mvptemplateproject.view.ExampleView;
import com.mvp.yetanothermvplibrary.presenter.BaseMvpPresenter;

import rx.Observable;

/**
 * Created by grishberg on 09.10.16.
 * Пример презентреа, в его функции входил бизнес-логика экрана, взаимодействие
 * с репозиториями (REST, DB)
 */
public class ExamplePresenterImpl extends BaseMvpPresenter<ExampleView, ExampleRepository>
        implements ExamplePresenter<ExampleView> {
    private static final String TAG = ExamplePresenterImpl.class.getSimpleName();

    @Override
    public Observable<ExampleModel> getData(final int id) {
        //TODO: Нужно как то проинжектить репозиторий
        final Observable<ExampleModel> observable = getRepository().getDataFromRestServer(id);
        RxUtils.wrapAsync(observable)
                // в UI потоке
                .subscribe(data -> {
                            // возвращаем результат во View
                            Log.d(TAG, "getData: received data");
                            getView().onGetData(data);
                        }, exception -> {
                            // предобработка ошибки
                            Log.e(TAG, "sendMessage: except", exception);
                            getView().onConnectionFail(exception.getMessage());
                        }

                );
        return observable;
    }
}
