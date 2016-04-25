package me.wangyuwei.xitukotlin.mvp.presenter

import android.util.Log

import me.wangyuwei.xitukotlin.entity.HotListEntity
import me.wangyuwei.xitukotlin.mvp.views.MainView
import me.wangyuwei.xitukotlin.rest.ApiUtil
import me.wangyuwei.xitukotlin.rest.XituApi
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.schedulers.Schedulers

/**
 * 作者： 巴掌 on 16/4/24 00:18
 */
class MainPresenter(private val mainView: MainView) {

    private val LIMIT = 30
    private val xituApi: XituApi

    init {
        xituApi = ApiUtil.createApi<XituApi>(XituApi::class.java)
    }

    fun loadData() {
        xituApi.getHotList("user,user.installation", "-rankIndex", LIMIT, 0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ hotList -> mainView.showHotList(hotList) }) { throwable -> Log.e("@=>e", throwable.message) }
    }

    fun loadMoreData(currentPage: Int) {
        xituApi.getHotList("user,user.installation", "-rankIndex", LIMIT, currentPage * LIMIT)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ hotList -> mainView.addHotListData(hotList) }, { throwable -> Log.e("@=>e", throwable.message) })

    }
}
