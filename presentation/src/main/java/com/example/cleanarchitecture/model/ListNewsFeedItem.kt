package com.example.cleanarchitecture.model

import com.example.cleanarchitecture.base.ItemMapper
import com.example.cleanarchitecture.base.ModelItem
import com.example.cleanarchitecture.domain.model.ListNewsFeed
import javax.inject.Inject

class ListNewsFeedItem(val listNewsFeedItem: List<NewsFeedItem>?) : ModelItem() {
}

class ListNewsFeedItemMapper @Inject constructor(private val newFeedItemMapper: NewFeedItemMapper) :
    ItemMapper<ListNewsFeed, ListNewsFeedItem> {
    override fun mapToPresentation(model: ListNewsFeed) = ListNewsFeedItem(
        model.listNewsFeed?.let { it.map { newFeedItemMapper.mapToPresentation(it) } }
    )

    override fun mapToDomain(modelItem: ListNewsFeedItem) = ListNewsFeed(
        modelItem.listNewsFeedItem?.let { it.map { newFeedItemMapper.mapToDomain(it) } }
    )
}