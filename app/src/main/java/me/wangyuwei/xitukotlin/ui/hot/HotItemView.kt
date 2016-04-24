package me.wangyuwei.xitukotlin.ui.hot

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import me.wangyuwei.xitukotlin.R
import me.wangyuwei.xitukotlin.entity.HotListEntity
import me.wangyuwei.xitukotlin.entity.ResultsEntity
import me.wangyuwei.xitukotlin.entity.ScreenshotEntity
import me.wangyuwei.xitukotlin.ui.view.BaseItemView
import me.wangyuwei.xitukotlin.utils.loadImage
import org.jetbrains.anko.find

/**
 * 作者： 巴掌 on 16/4/22 18:31
 */
class HotItemView<T>(context: Context) : BaseItemView<T>(context) {

    val iv_cover: ImageView by lazy { view.find<ImageView>(R.id.iv_cover) }
    val tv_title: TextView by lazy { view.find<TextView>(R.id.tv_title) }
    val tv_username: TextView by lazy { view.find<TextView>(R.id.tv_username) }

    override val layoutResource: Int
        get() = R.layout.rv_item_hot

    override fun setData(entity: T): BaseItemView<T> {
        var hotEntity = entity as ResultsEntity
        if(hotEntity.screenshot != null){
            loadImage((hotEntity.screenshot as ScreenshotEntity).url, iv_cover)
        }else{
            loadImage(R.mipmap.user_article_no_data, iv_cover)
        }
        tv_title.setText(hotEntity.title)
        tv_username.setText(hotEntity.user.username)
        return this
    }

    override fun onClick(v: View?) {

    }
}
