package net.practice.mvp.view;

import net.practice.ui.base.BaseView;
import net.practice.mvp.model.MainModel;

public interface MainView extends BaseView {

    void getDataSuccess(MainModel model);

    void getDataFail(String msg);
}
