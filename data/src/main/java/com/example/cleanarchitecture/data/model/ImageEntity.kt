package com.example.cleanarchitecture.data.model

import com.example.cleanarchitecture.data.base.EntityMapper
import com.example.cleanarchitecture.data.base.ModelEntity
import com.example.cleanarchitecture.domain.model.Image
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class ImageEntity(
    @SerializedName("href")
    val href: String?,
    @SerializedName("main_color")
    val mainColor: String?,
    @SerializedName("width")
    val width: Int?,
    @SerializedName("height")
    val height: Int?
): ModelEntity()

class ImageEntityMapper @Inject constructor() : EntityMapper<Image, ImageEntity> {

    override fun mapToDomain(entity: ImageEntity)= Image (
        entity.href, entity.mainColor, entity.width, entity.height
    )

    override fun mapToEntity(model: Image)= ImageEntity (
        model.href, model.mainColor, model.width, model.height
    )
}