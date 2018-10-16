package net.practice.retrofit;

import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class MoreBaseUrlInterceptor implements Interceptor {

    Map<String, String> map;
    String headerName;

    public MoreBaseUrlInterceptor(String headerName, Map<String, String> map) {
        this.map = map;
        this.headerName = headerName;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        //获取原始的originalRequest
        Request originalRequest = chain.request();
        //获取老的url
        HttpUrl oldUrl = originalRequest.url();
        //获取originalRequest的创建者builder
        Request.Builder builder = originalRequest.newBuilder();
        //获取头信息的集合如：manage,mdffx
        List<String> urlnameList = originalRequest.headers(headerName);

        if (urlnameList != null && urlnameList.size() > 0) {

            //删除原有配置中的值,就是namesAndValues集合里的值
            builder.removeHeader(headerName);

            //获取头信息中配置的value,如：manage或者mdffx
            String urlname = urlnameList.get(0);
            HttpUrl baseURL = null;

            //根据头信息中配置的value,来匹配新的base_url地址
            for (String key : map.keySet()) {
                if (key.equals(urlname)) {
                    baseURL = HttpUrl.parse(map.get(key));
                }
            }

            //重建新的HttpUrl，需要重新设置的url部分
            HttpUrl newHttpUrl = oldUrl.newBuilder()
                    .scheme(baseURL.scheme())//http协议如：http或者https
                    .host(baseURL.host())//主机地址
                    .port(baseURL.port())//端口
                    .build();

            //获取处理后的新newRequest
            Request newRequest = builder.url(newHttpUrl).build();

            Log.e("Url", "intercept: " + newHttpUrl.toString());

            return chain.proceed(newRequest);
        }

        return chain.proceed(originalRequest);
    }
}
