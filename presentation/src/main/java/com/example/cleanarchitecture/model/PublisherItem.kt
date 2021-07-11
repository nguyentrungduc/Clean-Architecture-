package com.example.cleanarchitecture.model

import com.example.cleanarchitecture.base.ItemMapper
import com.example.cleanarchitecture.base.ModelItem
import com.example.cleanarchitecture.domain.model.Publisher
import javax.inject.Inject

data class PublisherItem(
    val id: String?,
    val name: String?,
    val icon: String?
): ModelItem()

class PublisherItemMapper @Inject constructor() : ItemMapper<Publisher, PublisherItem> {
    override fun mapToPresentation(model: Publisher) = PublisherItem(
        model.id, model.name, model.icon
    )

    override fun mapToDomain(modelItem: PublisherItem) = Publisher(
        modelItem.id, modelItem.name, modelItem.icon
    )
}