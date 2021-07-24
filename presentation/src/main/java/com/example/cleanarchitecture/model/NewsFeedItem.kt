package com.example.cleanarchitecture.model

import com.example.cleanarchitecture.base.ItemMapper
import com.example.cleanarchitecture.base.ModelItem
import com.example.cleanarchitecture.domain.model.*
import com.example.cleanarchitecture.extension.changeTimeFormat
import javax.inject.Inject

data class NewsFeedItem(val documentId: String,
                       val title: String?,
                       val description: String?,
                       val contentType: String?,
                       val publishedDate: String?,
                       val publisher: PublisherItem?,
                       val originUrl: String?,
                       val avatarItem: AvatarItem?,
                       val imagesItem: List<ImageItem>?,
                       val content: Any?): ModelItem()

class NewFeedItemMapper @Inject constructor(private val publisherItemMapper: PublisherItemMapper,
                                            private val avatarItemMapper: AvatarItemMapper,
                                            private val imageItemMapper: ImageItemMapper) : ItemMapper<NewsFeed, NewsFeedItem> {

    companion object {
        private const val gtmFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'"
        private const val dateTimeFormat = "dd/MM/yyyy"
    }
    override fun mapToDomain(modelItem: NewsFeedItem) = NewsFeed(
        modelItem.documentId, modelItem.title, modelItem.description,
        modelItem.contentType, modelItem.publishedDate?.changeTimeFormat(dateTimeFormat, gtmFormat),
        modelItem.publisher?.let { publisherItemMapper.mapToDomain(it) },
        modelItem.originUrl,
        modelItem.avatarItem?.let { avatarItemMapper.mapToDomain(it) },
        modelItem.imagesItem?.let { it.map { imageItemMapper.mapToDomain(it) } },
        modelItem.content
    )

    override fun mapToPresentation(model: NewsFeed) = NewsFeedItem(
        model.documentId, model.title, model.description,
        model.contentType, model.publishedDate?.changeTimeFormat(gtmFormat, dateTimeFormat),
        model.publisher?.let { publisherItemMapper.mapToPresentation(it) },
        model.originUrl,
        model.avatar?.let { avatarItemMapper.mapToPresentation(it) },
        model.images?.let { it.map { imageItemMapper.mapToPresentation(it) } },
        model.content
    )
}