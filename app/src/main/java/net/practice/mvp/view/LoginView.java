package net.practice.mvp.view;


import net.practice.mvp.model.LoginModel;
import net.practice.ui.base.BaseView;

public interface LoginView extends BaseView {
    void getDataSuccess(LoginModel model);

    void getDataFail(String msg);
}
