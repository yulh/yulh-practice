package com.retrofit;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface ApiStores {

//    // 加载天气
//    @Headers({"urlname:sky"})
//    @GET("adat/sk/{cityId}.html")
//    Observable<MainModel> loadDataByReterofitRxJava(@Path("cityId") String cityId);
//
//    // 加载轮播图
//    @GET("{itemCount}item.json")
//    Call<BannerModel> fetchItemsWithItemCount(@Path("itemCount") int itemCount);
//
//    // 被扫
//    @Headers({"urlname:manage"})
//    @FormUrlEncoded
//    @POST("Api/NormPay.ashx?action=BeScan")
//    Observable<BeScanModel> beScan(@FieldMap Map<String, String> map);
//
//    @Headers({"urlname:app"})
//    @FormUrlEncoded
//    @POST("Api/Cashier.ashx?action=Login")
//    Observable<LoginModel> login(@FieldMap Map<String, String> map);
//
//    @Headers({"urlname:manage"})
//    @FormUrlEncoded
//    @POST("Api/NormPay.ashx?action=Query")
//    Observable<QueryTradeModel> queryTrade(@FieldMap Map<String, String> map);

    /**
     * 下载最新模板
     *
     * @return
     */
    @Streaming
    @GET
    Call<ResponseBody> downloadLatestFeature(@Url String fileUrl);
}
