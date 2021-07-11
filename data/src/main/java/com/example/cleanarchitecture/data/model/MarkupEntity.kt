package com.example.cleanarchitecture.data.model


import com.example.cleanarchitecture.data.base.EntityMapper
import com.example.cleanarchitecture.data.base.ModelEntity
import com.example.cleanarchitecture.domain.model.Markup
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class MarkupEntity(
    @SerializedName("markup_type")
    val markupType: Int?,
    @SerializedName("start")
    val start: Int?,
    @SerializedName("end")
    val end: Int?,
    @SerializedName("href")
    val href: String?
): ModelEntity()

class MarkupEntityMapper @Inject constructor() : EntityMapper<Markup, MarkupEntity> {

    override fun mapToDomain(entity: MarkupEntity)= Markup (
        entity.markupType, entity.start, entity.end, entity.href
    )

    override fun mapToEntity(model: Markup)= MarkupEntity (
        model.markupType, model.start, model.end, model.href
    )
}