package me.wangyuwei.xitukotlin.mvp.views

import me.wangyuwei.xitukotlin.entity.HotListEntity

/**
 * 作者： 巴掌 on 16/4/24 00:19
 */
interface MainView {

    fun showHotList(hotList: HotListEntity)

    fun addHotListData(hotList: HotListEntity)

}
