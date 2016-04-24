package me.wangyuwei.xitukotlin.utils

import com.ocpsoft.pretty.time.PrettyTime

/**
 * 作者： 巴掌 on 16/4/24 14:12
 */

fun getCommentTime(createAt: String): String {
    return PrettyTime().format(AVUtils.dateFromString(createAt))
}