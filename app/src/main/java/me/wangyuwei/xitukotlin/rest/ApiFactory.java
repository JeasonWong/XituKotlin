package me.wangyuwei.xitukotlin.rest;

import java.io.IOException;
import java.util.Map;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者： 巴掌 on 16/4/23 23:40
 */
public class ApiFactory {

    /**
     * @param clazz     API 类型
     * @param baseUrl   基础URL
     * @param headerMap Http头信息
     * @param <T>
     * @return
     */
    public static <T> T createRetrofitService(final Class clazz, String baseUrl, final Map<String, String> headerMap) {

        OkHttpClient okClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        Request.Builder requestBuilder;

                        if (headerMap == null) {
                            requestBuilder = original.newBuilder()
                                    .method(original.method(), original.body());
                        } else {
                            requestBuilder = original.newBuilder()
                                    .headers(addHeaders(headerMap))
                                    .method(original.method(), original.body());
                        }

                        Request request = requestBuilder.build();
                        /*Logger.d("url:" + request.url()+"\n"+
                                 "method:"+request.method()+"\n"+
                                 "header:" +request.headers().toString());*/

                        Response response = chain.proceed(request);

                        return response;
                    }
                })
                .build();


        Retrofit client = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        T service = (T) client.create(clazz);
        return service;
    }


    private static Headers addHeaders(Map<String, String> header) {
        Headers.Builder builder = new Headers.Builder();
        if (header != null) {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
        }
        return builder.build();
    }

}
