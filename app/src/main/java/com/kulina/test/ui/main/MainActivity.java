package com.kulina.test.ui.main;

import android.os.Bundle;

import com.kulina.test.R;
import com.kulina.test.ui.base.BaseActivity;
import com.kulina.test.ui.main.step.MainAdapter;
import com.stepstone.stepper.StepperLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject MainPresenter presenter;

    @BindView(R.id.stepper_layout) StepperLayout stepperLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter.attachView(this);
        presenter.initActivity();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void initWidget(){
        stepperLayout.setAdapter(new MainAdapter(getSupportFragmentManager(), this));
    }
}
