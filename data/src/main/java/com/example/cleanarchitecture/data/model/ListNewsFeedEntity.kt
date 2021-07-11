package com.example.cleanarchitecture.data.model

import com.example.cleanarchitecture.data.base.EntityMapper
import com.example.cleanarchitecture.data.base.ModelEntity
import com.example.cleanarchitecture.domain.model.ListNewsFeed
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class ListNewsFeedEntity(
    @SerializedName("items")
    val itemsEntity: List<NewFeedEntity>?

) : ModelEntity()

class ListNewsFeedEntityMapper @Inject constructor(
    private val newFeedEntityMapper: NewFeedEntityMapper
) : EntityMapper<ListNewsFeed, ListNewsFeedEntity> {
    override fun mapToDomain(entity: ListNewsFeedEntity) = ListNewsFeed(
        entity.itemsEntity?.let { it.map { newFeedEntityMapper.mapToDomain(it) } }
    )

    override fun mapToEntity(model: ListNewsFeed) = ListNewsFeedEntity(
        model.listNewsFeed?.let { it.map { newFeedEntityMapper.mapToEntity(it) } }
    )
}