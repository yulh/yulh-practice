package net.practice.retrofit;

import com.retrofit.BuildConfig;

import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {

    public static Retrofit mRetrofit;
    private String mBaseUrl;
    private String mHeaderName;
    private Map<String, String> mInterceptorMap;

    public ApiClient setBaseUrl(String baseUrl) {
        mBaseUrl = baseUrl;
        return this;
    }

    public ApiClient setHeaderName(String headerName) {
        mHeaderName = headerName;
        return this;
    }

    public ApiClient setInterceptorMap(Map<String, String> map) {
        mInterceptorMap = map;
        return this;
    }

    public Retrofit retrofit() {
        if (mRetrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            if (BuildConfig.DEBUG) {
                // Log信息拦截器
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                //设置 Debug Log 模式
                builder.addInterceptor(loggingInterceptor);
            }

            if (mInterceptorMap != null && mHeaderName != null) {
                builder.addInterceptor(new MoreBaseUrlInterceptor(mHeaderName, mInterceptorMap));
            }

            OkHttpClient okHttpClient = builder.build();
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(mBaseUrl)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }

        return mRetrofit;
    }
}
