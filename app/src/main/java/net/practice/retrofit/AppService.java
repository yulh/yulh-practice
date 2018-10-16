package net.practice.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class AppService {
    /**
     * 下载最新模板图片
     *
     * @param api
     */
    public static Call<ResponseBody> downloadLatestFeature(ApiStores api, String imageUrl) {
        return api.downloadLatestFeature(imageUrl);
    }
}
