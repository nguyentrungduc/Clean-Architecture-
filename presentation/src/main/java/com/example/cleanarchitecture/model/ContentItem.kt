package com.example.cleanarchitecture.model

import com.example.cleanarchitecture.base.ItemMapper
import com.example.cleanarchitecture.base.ModelItem
import com.example.cleanarchitecture.domain.model.Content
import javax.inject.Inject

data class ContentItem(val href: String?,
                       val caption: String?,
                       val duration: Int?,
                       val previewImageItem: ImageItem?,
                       val text: String?,
                       val markupItem: List<MarkupItem>?,
                       val mainColor: String?,
                       val originalWidth: Int?,
                       val originalHeight: Int?) : ModelItem()

class ContentItemMapper @Inject constructor(
    private val imageItemMapper: ImageItemMapper,
    private val markupItemMapper: MarkupItemMapper
) : ItemMapper<Content, ContentItem> {

    override fun mapToDomain(modelItem: ContentItem) = Content(
        modelItem.href, modelItem.caption, modelItem.duration,
        modelItem.previewImageItem?.let { imageItemMapper.mapToDomain(it) },
        modelItem.text,
        modelItem.markupItem?.let { it.map { markupItemMapper.mapToDomain(it) } },
        modelItem.mainColor,
        modelItem.originalWidth,
        modelItem.originalHeight
    )

    override fun mapToPresentation(model: Content) = ContentItem(
        model.href, model.caption, model.duration,
        model.previewImageEntity?.let { imageItemMapper.mapToPresentation(it) },
        model.text,
        model.markupEntities?.let { it.map { markupItemMapper.mapToPresentation(it) } },
        model.mainColor,
        model.originalWidth,
        model.originalHeight
    )
}
