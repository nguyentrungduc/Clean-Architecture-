package com.example.cleanarchitecture.data.model

import com.example.cleanarchitecture.data.base.EntityMapper
import com.example.cleanarchitecture.data.base.ModelEntity
import com.example.cleanarchitecture.domain.model.Publisher
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class PublisherEntity(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("icon")
    val icon: String?
): ModelEntity()

class PublisherEntityMapper @Inject constructor() : EntityMapper<Publisher, PublisherEntity> {

    override fun mapToDomain(entity: PublisherEntity)= Publisher (
        entity.id, entity.name, entity.icon
    )

    override fun mapToEntity(model: Publisher)= PublisherEntity (
        model.id, model.name, model.icon
    )
}