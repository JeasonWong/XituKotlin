package me.wangyuwei.xitukotlin.utils

import android.text.format.DateFormat

/**
 * 作者： 巴掌 on 16/4/24 14:12
 */

fun getCommentTime(createAt: String): String {
    return DateFormat.format("yyyy-MM-dd  HH:mm", AVUtils.dateFromString(createAt)).toString();
}