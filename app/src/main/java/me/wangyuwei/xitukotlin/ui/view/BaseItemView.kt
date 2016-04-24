package me.wangyuwei.xitukotlin.ui.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * 作者： 巴掌 on 16/4/23 20:30
 */
abstract class BaseItemView<T> : View.OnClickListener{

    val view: View
    val mContext: Context

    constructor(context: Context, root: ViewGroup? = null) {
        mContext = context
        view = LayoutInflater.from(context).inflate(layoutResource, root, false)
        view.setOnClickListener(this)
    }

    protected abstract val layoutResource: Int

    abstract fun setData(entity: T): BaseItemView<T>

}
