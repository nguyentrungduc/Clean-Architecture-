package com.example.cleanarchitecture.data.model


import com.example.cleanarchitecture.data.base.EntityMapper
import com.example.cleanarchitecture.data.base.ModelEntity
import com.example.cleanarchitecture.domain.model.DetailNewsFeed
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class DetailNewsFeedEntity(
    @SerializedName("document_id")
    val documentId: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("published_date")
    val publishedDate: String?,
    @SerializedName("origin_url")
    val originUrl: String?,
    @SerializedName("publisher")
    val publisher: PublisherEntity?,
    @SerializedName("template_type")
    val templateType: String?,
    @SerializedName("sections")
    val sectionEntities: List<SectionEntity>?
): ModelEntity()

class DetailNewsFeedEntityMapper @Inject constructor(
    private val publisherEntityMapper: PublisherEntityMapper,
    private val sectionEntityMapper: SectionEntityMapper
) : EntityMapper<DetailNewsFeed, DetailNewsFeedEntity> {

    override fun mapToDomain(entity: DetailNewsFeedEntity) = DetailNewsFeed(
        entity.documentId, entity.title, entity.description,
        entity.publishedDate,
        entity.originUrl,
        entity.publisher?.let { publisherEntityMapper.mapToDomain(it)  },
        entity.templateType,
        entity.sectionEntities?.let { it.map { sectionEntityMapper.mapToDomain(it) } }
    )

    override fun mapToEntity(model: DetailNewsFeed) = DetailNewsFeedEntity(
        model.documentId, model.title, model.description,
        model.publishedDate,
        model.originUrl,
        model.publisher?.let { publisherEntityMapper.mapToEntity(it)  },
        model.templateType,
        model.sectionEntities?.let { it.map { sectionEntityMapper.mapToEntity(it) } }
    )
}