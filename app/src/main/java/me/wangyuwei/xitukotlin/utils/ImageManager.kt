package me.wangyuwei.xitukotlin.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import me.wangyuwei.xitukotlin.AppContext

/**
 * 作者： 巴掌 on 16/4/24 10:18
 */

fun loadImage(url: String, view: ImageView) {
    Glide.with(AppContext.getInstance()).load(url).centerCrop().crossFade().into(view);
}

fun loadImage(resourceId: Int, view: ImageView) {
    Glide.with(AppContext.getInstance()).load(resourceId).centerCrop().crossFade().into(view);
}