package com.example.cleanarchitecture.data.model


import com.example.cleanarchitecture.data.base.EntityMapper
import com.example.cleanarchitecture.data.base.ModelEntity
import com.example.cleanarchitecture.domain.model.Section
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class SectionEntity(
    @SerializedName("section_type")
    var sectionType: Int? = null,
    @SerializedName("content")
    var contentEntity: ContentEntity? = null
): ModelEntity()

class SectionEntityMapper @Inject constructor(private val contentEntityMapper: ContentEntityMapper) : EntityMapper<Section, SectionEntity> {

    override fun mapToDomain(entity: SectionEntity)= Section (
        entity.sectionType, entity.contentEntity?.let { contentEntityMapper.mapToDomain(it) }
    )

    override fun mapToEntity(model: Section)= SectionEntity (
        model.sectionType, model.content?.let { contentEntityMapper.mapToEntity(it) }
    )
}