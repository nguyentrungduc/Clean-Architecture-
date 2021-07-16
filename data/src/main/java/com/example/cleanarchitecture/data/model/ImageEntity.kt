package com.example.cleanarchitecture.data.model


import com.example.cleanarchitecture.data.base.RealmEntityMapper
import com.example.cleanarchitecture.domain.model.Image
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import javax.inject.Inject

open class ImageEntity(
    @SerializedName("href")
    var href: String? = null,
    @SerializedName("main_color")
    var mainColor: String? = null,
    @SerializedName("width")
    var width: Int? = null,
    @SerializedName("height")
    var height: Int? = null
): RealmObject()

class ImageEntityMapper @Inject constructor() : RealmEntityMapper<Image, ImageEntity> {

    override fun mapToDomain(entity: ImageEntity)= Image (
        entity.href, entity.mainColor, entity.width, entity.height
    )

    override fun mapToEntity(model: Image)= ImageEntity (
        model.href, model.mainColor, model.width, model.height
    )
}