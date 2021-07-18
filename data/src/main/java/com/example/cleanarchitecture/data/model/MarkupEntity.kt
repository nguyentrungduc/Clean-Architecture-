package com.example.cleanarchitecture.data.model


import com.example.cleanarchitecture.data.base.EntityMapper
import com.example.cleanarchitecture.data.base.ModelEntity
import com.example.cleanarchitecture.domain.model.Markup
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class MarkupEntity(
    @SerializedName("markup_type")
    var markupType: Int?,
    @SerializedName("start")
    var start: Int?,
    @SerializedName("end")
    var end: Int?,
    @SerializedName("href")
    var href: String?
): ModelEntity()

class MarkupEntityMapper @Inject constructor() : EntityMapper<Markup, MarkupEntity> {

    override fun mapToDomain(entity: MarkupEntity)= Markup (
        entity.markupType, entity.start, entity.end, entity.href
    )

    override fun mapToEntity(model: Markup)= MarkupEntity (
        model.markupType, model.start, model.end, model.href
    )
}