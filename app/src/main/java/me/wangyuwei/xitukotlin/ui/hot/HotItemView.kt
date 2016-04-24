package me.wangyuwei.xitukotlin.ui.hot

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import me.wangyuwei.xitukotlin.R
import me.wangyuwei.xitukotlin.entity.ResultsEntity
import me.wangyuwei.xitukotlin.entity.ScreenshotEntity
import me.wangyuwei.xitukotlin.ui.activity.WebViewActivity
import me.wangyuwei.xitukotlin.ui.view.BaseItemView
import me.wangyuwei.xitukotlin.utils.getCommentTime
import me.wangyuwei.xitukotlin.utils.loadImage
import org.jetbrains.anko.find

/**
 * 作者： 巴掌 on 16/4/22 18:31
 */
class HotItemView<T>(context: Context) : BaseItemView<T>(context) {

    private val iv_cover: ImageView by lazy { view.find<ImageView>(R.id.iv_cover) }
    private val tv_title: TextView by lazy { view.find<TextView>(R.id.tv_title) }
    private val tv_username: TextView by lazy { view.find<TextView>(R.id.tv_username) }
    private val tv_create_time: TextView by lazy { view.find<TextView>(R.id.tv_create_time) }
    private val tv_view: TextView by lazy { view.find<TextView>(R.id.tv_view) }
    private val tv_collection: TextView by lazy { view.find<TextView>(R.id.tv_collection) }

    override val layoutResource: Int
        get() = R.layout.rv_item_hot

    override fun setData(entity: T): BaseItemView<T> {
        var hotEntity = entity as ResultsEntity
        if(hotEntity.screenshot != null){
            loadImage((hotEntity.screenshot as ScreenshotEntity).url, iv_cover)
        }else{
            loadImage(R.mipmap.user_article_no_data, iv_cover)
        }
        tv_title.text = hotEntity.title
        tv_username.text = hotEntity.user.username
        tv_create_time.text = getCommentTime(hotEntity.createdAt)
        tv_view.text = hotEntity.viewsCount.toString()
        tv_collection.text = hotEntity.collectionCount.toString()
        view.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent()
            intent.setClass(mContext, WebViewActivity::class.java)
            val bundle : Bundle = Bundle()
            bundle.putString(WebViewActivity.EXTRA_URL, hotEntity.url)
            intent.putExtras(bundle)
            (mContext as Activity).startActivity(intent)
        })
        return this
    }

}
