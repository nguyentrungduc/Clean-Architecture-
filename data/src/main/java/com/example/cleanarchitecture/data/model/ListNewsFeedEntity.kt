package com.example.cleanarchitecture.data.model

import com.example.cleanarchitecture.data.base.EntityMapper
import com.example.cleanarchitecture.data.base.ModelEntity
import com.example.cleanarchitecture.domain.model.ListNewsFeed
import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.annotations.RealmClass
import javax.inject.Inject

open class ListNewsFeedEntity(
    @SerializedName("items")
    var itemsEntity: List<NewFeedEntity>? = null

) : ModelEntity()
class ListNewsFeedEntityMapper @Inject constructor(
    private val newFeedEntityMapper: NewFeedEntityMapper
) : EntityMapper<ListNewsFeed, ListNewsFeedEntity> {
    override fun mapToDomain(entity: ListNewsFeedEntity) = ListNewsFeed(
        entity.itemsEntity?.let { it.map { newFeedEntityMapper.mapToDomain(it) } }
    )

    override fun mapToEntity(model: ListNewsFeed) = ListNewsFeedEntity(
        model.listNewsFeed?.let { it.map { newFeedEntityMapper.mapToEntity(it) } } as RealmList<NewFeedEntity>?
    )
}