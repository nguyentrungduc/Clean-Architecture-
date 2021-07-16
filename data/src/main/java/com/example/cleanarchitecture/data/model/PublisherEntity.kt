package com.example.cleanarchitecture.data.model

import com.example.cleanarchitecture.data.base.RealmEntityMapper
import com.example.cleanarchitecture.domain.model.Publisher
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import javax.inject.Inject

open class PublisherEntity(
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("icon")
    var icon: String? = null
): RealmObject()

class PublisherEntityMapper @Inject constructor() : RealmEntityMapper<Publisher, PublisherEntity> {

    override fun mapToDomain(entity: PublisherEntity)= Publisher (
        entity.id, entity.name, entity.icon
    )

    override fun mapToEntity(model: Publisher)= PublisherEntity (
        model.id, model.name, model.icon
    )
}