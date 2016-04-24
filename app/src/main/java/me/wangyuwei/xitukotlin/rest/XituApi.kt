package me.wangyuwei.xitukotlin.rest

import me.wangyuwei.xitukotlin.entity.HotListEntity
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * 作者： 巴掌 on 16/4/23 23:41
 */
interface XituApi {

    @GET("classes/Entry")
    fun getHotList(@Query("include") include: String, @Query("order") order: String, @Query("limit") limit: Int): Observable<HotListEntity>

}
