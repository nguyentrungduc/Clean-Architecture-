package com.example.cleanarchitecture.data.model


import com.example.cleanarchitecture.data.base.EntityMapper
import com.example.cleanarchitecture.data.base.ModelEntity
import com.example.cleanarchitecture.domain.model.Avatar
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class AvatarEntity(
    @SerializedName("href")
    val href: String?,
    @SerializedName("main_color")
    val mainColor: String?,
    @SerializedName("width")
    val width: Int?,
    @SerializedName("height")
    val height: Int?
) : ModelEntity()

class AvatarEntityMapper @Inject constructor() : EntityMapper<Avatar, AvatarEntity> {

    override fun mapToDomain(entity: AvatarEntity)= Avatar (
        entity.href, entity.mainColor, entity.width, entity.height
    )

    override fun mapToEntity(model: Avatar)= AvatarEntity (
        model.href, model.mainColor, model.width, model.height
    )
}