package net.practice.mvp.presenter;



import com.retrofit.ApiCallback;

import net.practice.mvp.model.LoginModel;
import net.practice.mvp.view.LoginView;
import net.practice.ui.base.BasePresenter;

import java.util.Map;

public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter(LoginView view) {
        attachView(view);
    }

    public void login(Map<String, String> map) {
        mvpView.showLoading();
        addSubscription(apiStores.login(map), new ApiCallback<LoginModel>() {
            @Override
            public void onSuccess(LoginModel model) {
                mvpView.getDataSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mvpView.getDataFail(msg);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        });
    }
}
