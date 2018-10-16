package net.practice.ui.base;


import com.retrofit.ApiClient;

import net.practice.retrofit.ApiStores;
import net.practice.utlis.AppUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class BasePresenter<V> {
    public V mvpView;
    protected ApiStores apiStores;
    private CompositeDisposable mCompositeDisposable;

    public void attachView(V mvpView) {
        this.mvpView = mvpView;

        Map<String, String> map = new HashMap<String, String>();
        map.put("manage", AppUtils.payUrl);
        map.put("sky", AppUtils.weatherUrl);
        map.put("app", AppUtils.appUrl);
        map.put("bannar", AppUtils.bannarUrl);

        apiStores = new ApiClient()
                .setBaseUrl(AppUtils.payUrl)
                .setHeaderName("urlName")
                .setInterceptorMap(map)
                .retrofit()
                .create(ApiStores.class);
    }


    public void detachView() {
        this.mvpView = null;
        onUnSubscribe();
    }


    //RxJava取消注册，以避免内存泄露
    public void onUnSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }


    public void addSubscription(Observable observable, DisposableObserver observer) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }

        mCompositeDisposable.add(observer);

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer);
    }
}
