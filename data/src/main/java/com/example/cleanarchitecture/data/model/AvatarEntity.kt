package com.example.cleanarchitecture.data.model


import com.example.cleanarchitecture.data.base.RealmEntityMapper
import com.example.cleanarchitecture.domain.model.Avatar
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import javax.inject.Inject

open class AvatarEntity(
    @SerializedName("href")
    var href: String? = null,
    @SerializedName("main_color")
    var mainColor: String? = null,
    @SerializedName("width")
    var width: Int? = null,
    @SerializedName("height")
    var height: Int? = null
) : RealmObject()

class AvatarEntityMapper @Inject constructor() : RealmEntityMapper<Avatar, AvatarEntity> {

    override fun mapToDomain(entity: AvatarEntity)= Avatar (
        entity.href, entity.mainColor, entity.width, entity.height
    )

    override fun mapToEntity(model: Avatar)= AvatarEntity (
        model.href, model.mainColor, model.width, model.height
    )
}