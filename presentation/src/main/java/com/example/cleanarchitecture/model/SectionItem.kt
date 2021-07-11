package com.example.cleanarchitecture.model

import com.example.cleanarchitecture.base.ItemMapper
import com.example.cleanarchitecture.base.ModelItem
import com.example.cleanarchitecture.domain.model.Section
import javax.inject.Inject

data class SectionItem(val sectionType: Int?,
                  val contentItem: ContentItem?) : ModelItem(){
}

class SectionItemMapper @Inject constructor(private val contentItemMapper: ContentItemMapper) :
    ItemMapper<Section, SectionItem> {

    override fun mapToDomain(modelItem: SectionItem)= Section (
        modelItem.sectionType, modelItem.contentItem?.let { contentItemMapper.mapToDomain(it) }
    )

    override fun mapToPresentation(model: Section)= SectionItem (
        model.sectionType, model.content?.let { contentItemMapper.mapToPresentation(it) }
    )
}