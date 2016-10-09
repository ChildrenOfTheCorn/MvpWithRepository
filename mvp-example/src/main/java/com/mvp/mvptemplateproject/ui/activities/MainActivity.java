package com.mvp.mvptemplateproject.ui.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.mvp.mvptemplateproject.App;
import com.mvp.mvptemplateproject.R;
import com.mvp.mvptemplateproject.model.ExampleModel;
import com.mvp.mvptemplateproject.presenter.ExamplePresenter;
import com.mvp.mvptemplateproject.view.ExampleView;
import com.mvp.yetanothermvplibrary.view.BaseMvpActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseMvpActivity<ExamplePresenter> implements ExampleView {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    ExamplePresenter presenter;
    @Bind(R.id.btnSomeAction)
    Button btnSomeAction;
    @Bind(R.id.tvText)
    TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnSomeAction.setOnClickListener(view -> getPresenter().getData(0));
    }

    @Override
    public void onGetData(ExampleModel data) {
        Log.d(TAG, "onGetData: ");
        tvText.setText("data received");
    }

    @Override
    public void onConnectionFail(String message) {
        Log.e(TAG, "onConnectionFail: ");
        tvText.setText(message);
    }

    @Override
    protected ExamplePresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void inject() {
        App.getAppComponent().inject(this);
    }
}
