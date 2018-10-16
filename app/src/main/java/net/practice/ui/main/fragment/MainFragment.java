package net.practice.ui.main.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import net.practice.R;
import net.practice.app.ExampleApplication;
import net.practice.mvp.model.WeatherInfoModel;
import net.practice.mvp.presenter.MainFragmentPresenter;
import net.practice.mvp.view.MainFragPresenterView;
import net.practice.ui.base.BasePresenter;
import net.practice.mvp.model.BannerModel;
import net.practice.ui.base.BaseFragment;
import net.practice.utlis.LogUtil;
import net.practice.utlis.ToastUtil;
import net.practice.utlis.view.CircleProgressbar;

import butterknife.BindView;
import cn.bingoogolapple.bgabanner.BGABanner;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends BaseFragment<MainFragmentPresenter> implements BGABanner.Delegate<ImageView, String>, BGABanner.Adapter<ImageView, String>, MainFragPresenterView {

    @BindView(R.id.banner_main_alpha)
    public BGABanner bgaBanner;


    @Override
    public int getLayoutID() {
        return R.layout.fragment_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void setListener() {
    }

    @Override
    public void initData() {
        loadData();
    }

    private void loadData() {
        mvpPresenter.fetchItemsWithItemCount(6);
    }

    @Override
    public MainFragmentPresenter createPresenter() {
        return new MainFragmentPresenter(this);
    }

    @Override
    public void fillBannerItem(BGABanner banner, ImageView itemView, @Nullable String model, int position) {
        Glide.with(itemView.getContext())
                .load(model)
                .apply(new RequestOptions().placeholder(R.drawable.holder).error(R.drawable.holder).dontAnimate().centerCrop())
                .into(itemView);
    }

    @Override
    public void onBannerItemClick(BGABanner banner, ImageView itemView, @Nullable String model, int position) {

    }

    @Override
    public void getBannarData(BannerModel bannerModel) {
        if (bannerModel != null) {
            bgaBanner.setAutoPlayAble(bannerModel.imgs.size() > 1);

            bgaBanner.setAdapter(MainFragment.this);
            bgaBanner.setData(bannerModel.imgs, bannerModel.tips);
        }

        mvpPresenter.loadDataByRetrofitRxJava("101210101");
    }

    @Override
    public void getSkyData(WeatherInfoModel data) {
        LogUtil.e("sky:" + data);
    }

    @Override
    public void getDataFail(String msg) {
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
