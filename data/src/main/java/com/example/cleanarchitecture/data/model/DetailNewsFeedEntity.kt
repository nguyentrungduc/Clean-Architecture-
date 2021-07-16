package com.example.cleanarchitecture.data.model


import com.example.cleanarchitecture.data.base.EntityMapper
import com.example.cleanarchitecture.data.base.ModelEntity
import com.example.cleanarchitecture.domain.model.DetailNewsFeed
import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import javax.inject.Inject

open class DetailNewsFeedEntity(
    @SerializedName("document_id")
    var documentId: String?= null,
    @SerializedName("title")
    var title: String?= null,
    @SerializedName("description")
    var description: String?= null,
    @SerializedName("published_date")
    var publishedDate: String?= null,
    @SerializedName("origin_url")
    var originUrl: String?= null,
    @SerializedName("publisher")
    var publisher: PublisherEntity?= null,
    @SerializedName("template_type")
    var templateType: String?= null,
    @SerializedName("sections")
    var sectionEntities: RealmList<SectionEntity>?= null
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
        model.sectionEntities?.let { it.map { sectionEntityMapper.mapToEntity(it) } } as RealmList<SectionEntity>?
    )
}