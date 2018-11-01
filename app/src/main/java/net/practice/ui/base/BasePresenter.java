package net.practice.ui.base;


import net.practice.app.StaticParamterUtil;
import net.practice.retrofit.ApiClient;
import net.practice.retrofit.ApiStores;

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
        map.put("manage", StaticParamterUtil.payUrl);
        map.put("sky", StaticParamterUtil.weatherUrl);
        map.put("app", StaticParamterUtil.appUrl);
        map.put("bannar", StaticParamterUtil.bannarUrl);

        apiStores = new ApiClient()
                .setBaseUrl(StaticParamterUtil.payUrl)
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
