package com.example.cleanarchitecture.data.model

import com.example.cleanarchitecture.data.base.EntityMapper
import com.example.cleanarchitecture.data.base.ModelEntity
import com.example.cleanarchitecture.domain.model.ListNewsFeed
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class ListNewsFeedEntity(
    @SerializedName("items")
    var itemsEntity: List<NewsFeedEntity>?

) : ModelEntity()
class ListNewsFeedEntityMapper @Inject constructor(
    private val newsFeedEntityMapper: NewsFeedEntityMapper
) : EntityMapper<ListNewsFeed, ListNewsFeedEntity> {
    override fun mapToDomain(entity: ListNewsFeedEntity) = ListNewsFeed(
        entity.itemsEntity?.let { it.map { newsFeedEntityMapper.mapToDomain(it) } }
    )

    override fun mapToEntity(model: ListNewsFeed) = ListNewsFeedEntity(
        model.listNewsFeed?.let { it.map { newsFeedEntityMapper.mapToEntity(it) } }
    )

    fun mapListNewsFeed(listNewsFeed: List<NewsFeedEntity>) = mapToDomain(ListNewsFeedEntity(listNewsFeed))
}