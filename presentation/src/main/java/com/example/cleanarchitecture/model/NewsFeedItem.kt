package com.example.cleanarchitecture.model

import com.example.cleanarchitecture.base.ItemMapper
import com.example.cleanarchitecture.base.ModelItem
import com.example.cleanarchitecture.domain.model.*
import javax.inject.Inject

data class NewsFeedItem(val documentId: String?,
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

    override fun mapToDomain(modelItem: NewsFeedItem) = NewsFeed(
        modelItem.documentId, modelItem.title, modelItem.description,
        modelItem.contentType, modelItem.publishedDate,
        modelItem.publisher?.let { publisherItemMapper.mapToDomain(it) },
        modelItem.originUrl,
        modelItem.avatarItem?.let { avatarItemMapper.mapToDomain(it) },
        modelItem.imagesItem?.let { it.map { imageItemMapper.mapToDomain(it) } },
        modelItem.content
    )

    override fun mapToPresentation(model: NewsFeed) = NewsFeedItem(
        model.documentId, model.title, model.description,
        model.contentType, model.publishedDate,
        model.publisher?.let { publisherItemMapper.mapToPresentation(it) },
        model.originUrl,
        model.avatar?.let { avatarItemMapper.mapToPresentation(it) },
        model.images?.let { it.map { imageItemMapper.mapToPresentation(it) } },
        model.content
    )
}