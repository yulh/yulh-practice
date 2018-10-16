package com.utils;

import com.retrofit.ApiStores;
import com.retrofit.AppService;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DownloadImageUtils {

    public final static String APP_IMAGE_DIR = "";

    /**
     * 下载图片到SD卡
     *
     * @param mApi
     * @param url
     * @param imageName
     */
    public static void downloadLatestFeature(ApiStores mApi, final String url, final String imageName) {
        Call<ResponseBody> resultCall = AppService.downloadLatestFeature(mApi, url);
        resultCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                writeResponseBodyToDisk(imageName, response.body());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
            }
        });
    }

    /**
     * 保存下载的图片流写入SD卡文件
     *
     * @param imageName xxx.jpg
     * @param body      image stream
     */
    public static void writeResponseBodyToDisk(String imageName, ResponseBody body) {
        if (body == null) {
            //ToastUtils.showToast("图片源错误");
            return;
        }
        try {
            InputStream is = body.byteStream();
            File fileDr = new File(APP_IMAGE_DIR);
            if (!fileDr.exists()) {
                fileDr.mkdir();
            }
            File file = new File(APP_IMAGE_DIR, imageName);
            if (file.exists()) {
                file.delete();
                file = new File(APP_IMAGE_DIR, imageName);
            }
            FileOutputStream fos = new FileOutputStream(file);
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            fos.flush();
            fos.close();
            bis.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
