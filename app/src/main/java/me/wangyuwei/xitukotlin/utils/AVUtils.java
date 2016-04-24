package me.wangyuwei.xitukotlin.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import me.wangyuwei.xitukotlin.BuildConfig;

/**
 * 作者： 巴掌 on 16/4/24 14:17
 */
public class AVUtils {

    private static final ThreadLocal<SimpleDateFormat> THREAD_LOCAL_DATE_FORMAT = new ThreadLocal();
    public static final int TYPE_MOBILE = 2;
    public static final int TYPE_NOT_CONNECTED = 0;
    public static final int TYPE_WIFI = 1;
    private static final String dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static Date dateFromString(String str) {
        if (isBlankString(str)) {
            return null;
        }
        if (isDigitString(str)) {
            return new Date(Long.parseLong(str));
        }
        Date parse;
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) THREAD_LOCAL_DATE_FORMAT.get();
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat(dateFormat);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            THREAD_LOCAL_DATE_FORMAT.set(simpleDateFormat);
        }
        try {
            parse = simpleDateFormat.parse(str);
        } catch (Exception e) {
            parse = null;
        }
        return parse;
    }

    public static boolean isBlankString(String str) {
        return str == null || str.trim().equals(BuildConfig.FLAVOR);
    }

    public static boolean isDigitString(String str) {
        if (str == null) {
            return false;
        }
        for (int i = TYPE_NOT_CONNECTED; i < str.length(); i += TYPE_WIFI) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
