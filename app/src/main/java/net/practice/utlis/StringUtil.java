package net.practice.utlis;

public class StringUtil {

    /**
     * 判断字符串是否为空值
     *
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str) {

        boolean flag = false;
        if (str == null) {
            flag = true;
        }

        if (str.equals("")) {
            flag = true;
        }

        return flag;
    }
}
