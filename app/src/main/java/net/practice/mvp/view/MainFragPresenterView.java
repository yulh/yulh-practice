package net.practice.mvp.view;

import net.practice.mvp.model.BannerModel;
import net.practice.mvp.model.WeatherInfoModel;
import net.practice.ui.base.BaseView;

public interface MainFragPresenterView extends BaseView {
    void getBannarData(BannerModel model);

    void getSkyData(WeatherInfoModel model);

    void getDataFail(String msg);
}
