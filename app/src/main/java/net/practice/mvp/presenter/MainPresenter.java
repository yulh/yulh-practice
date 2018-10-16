package net.practice.mvp.presenter;

import com.retrofit.ApiCallback;

import net.practice.mvp.model.MainModel;
import net.practice.mvp.view.MainView;
import net.practice.ui.base.BasePresenter;

public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView view) {
        attachView(view);
    }


}
