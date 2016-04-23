package me.wangyuwei.xitukotlin.ui.hot

import android.content.Context
import android.widget.TextView
import me.wangyuwei.xitukotlin.R
import me.wangyuwei.xitukotlin.entity.HotList
import me.wangyuwei.xitukotlin.ui.view.BaseItemView
import org.jetbrains.anko.find

/**
 * 作者： 巴掌 on 16/4/22 18:31
 */
class HotItemView<T>(context: Context) : BaseItemView<T>(context) {

    val tv_title: TextView by lazy { view.find<TextView>(R.id.tv_title) }

    override val layoutResource: Int
        get() = R.layout.rv_item_hot

    override fun setData(entity: T): BaseItemView<T> {
        var hotEntity = entity as HotList.ResultsEntity
        tv_title.setText(hotEntity.title)
        return this
    }


}
