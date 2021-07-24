package com.example.cleanarchitecture.model

import com.example.cleanarchitecture.base.ItemMapper
import com.example.cleanarchitecture.base.ModelItem
import com.example.cleanarchitecture.domain.model.DetailNewsFeed
import javax.inject.Inject

class DetailNewsFeedItem(
    val documentId: String?,
    val title: String?,
    val description: String?,
    val publishedDate: String?,
    val originUrl: String?,
    val publisherItem: PublisherItem?,
    val templateType: String?,
    val sectionItems: List<SectionItem>?): ModelItem() {
}

class DetailNewsFeedItemMapper @Inject constructor(
    private val publisherItemMapper: PublisherItemMapper,
    private val sectionItemMapper: SectionItemMapper
) : ItemMapper<DetailNewsFeed, DetailNewsFeedItem> {

    override fun mapToDomain(modelItem: DetailNewsFeedItem) = DetailNewsFeed(
        modelItem.documentId, modelItem.title, modelItem.description,
        modelItem.publishedDate,
        modelItem.originUrl,
        modelItem.publisherItem?.let { publisherItemMapper.mapToDomain(it)  },
        modelItem.templateType,
        modelItem.sectionItems?.let { it.map { sectionItemMapper.mapToDomain(it) } }
    )

    override fun mapToPresentation(model: DetailNewsFeed) = DetailNewsFeedItem(
        model.documentId, model.title, model.description,
        model.publishedDate,
        model.originUrl,
        model.publisher?.let { publisherItemMapper.mapToPresentation(it)  },
        model.templateType,
        model.sectionEntities?.let { it.map { sectionItemMapper.mapToPresentation(it) } }
//            ?.filter {
//            !it.contentItem?.href.isNullOrBlank()}
    )

}