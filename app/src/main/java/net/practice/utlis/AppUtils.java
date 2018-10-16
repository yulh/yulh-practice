package net.practice.utlis;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeMap;

public class AppUtils {

    public static String userCode = "99999999";
    public static String privateKey = "4550cc08dc5e4fb6";

    public static final String IS_FIRST_LOGIN = "Is_First_Login";
    public static final String IS_AlREADY_LOGIN = "Is_Already_Login";

    public static String appUrl = "http://qr.irichpay.com/";
    public static String payUrl = "http://h5.irichpay.com/";
    public static String weatherUrl = "http://www.weather.com.cn/";
    public static String bannarUrl = "http://7xk9dj.com1.z0.glb.clouddn.com/";

    public static String getTimeByFommat() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        return df.format(new Date());
    }

    public static String getTimeByFommatGeLin() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");//设置日期格式
        return df.format(new Date());
    }

    /**
     * 利用MD5进行加密
     *
     * @param str 待加密的字符串
     * @return 加密后的字符串
     * @throws NoSuchAlgorithmException     没有这种产生消息摘要的算法
     * @throws UnsupportedEncodingException
     */
    public static String EncoderByMd5(String str, String data) {
        //确定计算方法
        String privateKeysign = Md5Encrypt.md5(str).toUpperCase();
        String singData = Md5Encrypt.md5(privateKeysign + data).toUpperCase();

        return singData;
    }

    public static String getBeforeSignByASCII(TreeMap<String, String> map) {
        StringBuffer result = new StringBuffer();
        Set<String> set = map.keySet();
        for (String mapKey : set) {

            if (map.get(mapKey) == null || map.get(mapKey).equals("")) {
                continue;
            }

            result.append(mapKey + "=" + map.get(mapKey) + "&");
        }
        return result.length() > 0 ? result.substring(0, result.length() - 1) : "";
    }
}
