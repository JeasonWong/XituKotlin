package me.wangyuwei.xitukotlin.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone

import me.wangyuwei.xitukotlin.BuildConfig

/**
 * 作者： 巴掌 on 16/4/24 14:17
 */

val TYPE_MOBILE = 2
val TYPE_NOT_CONNECTED = 0
val TYPE_WIFI = 1
private val dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

fun dateFromString(str: String): Date? {
    if (isBlankString(str)) {
        return null
    }
    if (isDigitString(str)) {
        return Date(java.lang.Long.parseLong(str))
    }

    val simpleDateFormat: SimpleDateFormat = SimpleDateFormat(dateFormat)
    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"))

    val parse: Date?

    try {
        parse = simpleDateFormat.parse(str)
    } catch (e: Exception) {
        parse = null
    }

    return parse
}

fun isBlankString(str: String?): Boolean {
    return str == null || str.trim { it <= ' ' } == BuildConfig.FLAVOR
}

fun isDigitString(str: String?): Boolean {
    if (str == null) {
        return false
    }
    var i = TYPE_NOT_CONNECTED
    while (i < str.length) {
        if (!Character.isDigit(str[i])) {
            return false
        }
        i += TYPE_WIFI
    }
    return true
}

