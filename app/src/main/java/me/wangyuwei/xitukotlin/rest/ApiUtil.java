package me.wangyuwei.xitukotlin.rest;

import android.content.res.Resources;

import java.util.HashMap;
import java.util.Map;

import me.wangyuwei.xitukotlin.AppContext;
import me.wangyuwei.xitukotlin.R;

/**
 * 作者： 巴掌 on 16/4/23 23:17
 */
public class ApiUtil {

    public static String getBaseUrl(){
        Resources resources = AppContext.getInstance().getResources();
        return resources.getString(R.string.xitu_api_release);
    }

    public static <T> T createApi(final Class clazz) {
        return createApi(clazz, getBaseUrl());
    }

    public static <T> T createApi(Class clazz, String baseUrl) {
        Map<String, String> map = new HashMap<>();
        map.put("X-LC-Sign", "24d2902742c600b397671fae1f70be11,1461310390209");
        map.put("X-LC-Id", "mhke0kuv33myn4t4ghuid4oq2hjj12li374hvcif202y5bm6");
        return createApi(clazz, baseUrl, map);
    }

    public static <T> T createApi(Class clazz, String baseUrl, Map<String, String> headerMap) {
        return ApiFactory.createRetrofitService(clazz, baseUrl, headerMap);
    }

}
