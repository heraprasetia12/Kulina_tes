package com.kulina.test.ui.main;

import com.kulina.test.data.DataManager;
import com.kulina.test.ui.base.BasePresenter;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainMvpView> {

    private DataManager dataManager;

    @Inject
    public MainPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void initActivity(){
        if (isViewAttached()){
            getMvpView().initWidget();
        }
    }
}
