package me.wangyuwei.xitukotlin.rest;

import me.wangyuwei.xitukotlin.entity.HotList;
import retrofit2.http.GET;
import rx.Observable;

/**
 * 作者： 巴掌 on 16/4/23 23:41
 */
public interface XituApi {

    @GET("classes/Entry")
    Observable<HotList> getHotList();

}
