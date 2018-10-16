package net.practice.mvp.presenter;


import net.practice.mvp.model.BannerModel;
import net.practice.mvp.model.WeatherInfoModel;
import net.practice.mvp.view.MainFragPresenterView;
import net.practice.retrofit.ApiCallback;
import net.practice.ui.base.BasePresenter;

public class MainFragmentPresenter extends BasePresenter<MainFragPresenterView> {
    public MainFragmentPresenter(MainFragPresenterView view) {
        attachView(view);
    }

    public void fetchItemsWithItemCount(int count) {
        addSubscription(apiStores.fetchItemsWithItemCount(count),
                new ApiCallback<BannerModel>() {
                    @Override
                    public void onSuccess(BannerModel model) {
                        mvpView.getBannarData(model);
                    }

                    @Override
                    public void onFailure(String msg) {
                    }

                    @Override
                    public void onFinish() {
                    }
                });
    }

    public void loadDataByRetrofitRxJava(String cityId) {
        mvpView.showLoading();
        addSubscription(apiStores.loadDataByReterofitRxJava(cityId),
                new ApiCallback<WeatherInfoModel>() {
                    @Override
                    public void onSuccess(WeatherInfoModel model) {
                        mvpView.getSkyData(model);
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
