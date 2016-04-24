package me.wangyuwei.xitukotlin.entity

/**
 * 作者： 巴掌 on 16/4/24 12:25
 */
class ResultsEntity(
        var updatedAt: String,
        var url: String?,
        var viewsCount: Int,
        var collectionCount: Int,
        var createdAt: String,
        var type: String,
        var title: String,
        var user: UserEntity,
        var screenshot: ScreenshotEntity?,
        var originalUrl: String?
)