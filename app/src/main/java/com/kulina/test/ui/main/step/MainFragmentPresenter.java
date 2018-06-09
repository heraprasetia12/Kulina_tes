package com.kulina.test.ui.main.step;

import com.kulina.test.data.DataManager;
import com.kulina.test.ui.base.BasePresenter;

import javax.inject.Inject;

public class MainFragmentPresenter extends BasePresenter<MainFragmentMvpView> {

    private DataManager dataManager;

    @Inject

    public MainFragmentPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(MainFragmentMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void initFragment(){
        isViewAttached();
    }

}
