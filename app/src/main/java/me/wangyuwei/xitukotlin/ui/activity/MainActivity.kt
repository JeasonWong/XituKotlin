package me.wangyuwei.xitukotlin.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import me.wangyuwei.xitukotlin.R
import me.wangyuwei.xitukotlin.entity.HotListEntity
import me.wangyuwei.xitukotlin.mvp.presenter.MainPresenter
import me.wangyuwei.xitukotlin.mvp.views.MainView
import me.wangyuwei.xitukotlin.ui.hot.HotAdapter
import me.wangyuwei.xitukotlin.widget.EndlessRecyclerOnScrollListener
import org.jetbrains.anko.find

/**
 * 作者： 巴掌 on 16/4/22 18:09
 */
class MainActivity : AppCompatActivity(), MainView{

    private val rv_hot: RecyclerView by lazy { find<RecyclerView>(R.id.rv_hot) }
    private lateinit var mHotAdapter: HotAdapter
    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mHotAdapter = HotAdapter(this)
        rv_hot.adapter = mHotAdapter
        val layoutManager: LinearLayoutManager = LinearLayoutManager(this)
        rv_hot.layoutManager = layoutManager
        rv_hot.addOnScrollListener(object : EndlessRecyclerOnScrollListener(layoutManager){
            override fun onLoadMore(currentPage: Int) {
                mainPresenter.loadMoreData(currentPage)
            }
        });

        mainPresenter = MainPresenter(this)
        mainPresenter.loadData()
    }

    override fun showHotList(hotList: HotListEntity) {
        mHotAdapter.setData(hotList.results)
    }

    override fun addHotListData(hotList: HotListEntity) {
        mHotAdapter.addData(hotList.results)
    }
}
