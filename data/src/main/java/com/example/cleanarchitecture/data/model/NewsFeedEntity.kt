package com.example.cleanarchitecture.data.model


import com.example.cleanarchitecture.data.base.EntityMapper
import com.example.cleanarchitecture.data.base.ModelEntity
import com.example.cleanarchitecture.domain.model.NewsFeed
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class NewFeedEntity(
    @SerializedName("document_id")
    val documentId: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("content_type")
    val contentType: String?,
    @SerializedName("published_date")
    val publishedDate: String?,
    @SerializedName("publisher")
    val publisherEntity: PublisherEntity?,
    @SerializedName("origin_url")
    val originUrl: String?,
    @SerializedName("avatar")
    val avatarEntity: AvatarEntity?,
    @SerializedName("images")
    val imagesEntity: List<ImageEntity>?,
    @SerializedName("content")
    val content: Any?
) : ModelEntity()

class NewFeedEntityMapper @Inject constructor(private val publisherEntityMapper: PublisherEntityMapper,
                                              private val avatarEntityMapper: AvatarEntityMapper,
                                              private val imageEntityMapper: ImageEntityMapper)
    : EntityMapper<NewsFeed, NewFeedEntity> {

    override fun mapToDomain(entity: NewFeedEntity) = NewsFeed(
        entity.documentId, entity.title, entity.description, entity.contentType, entity.publishedDate,
        entity.publisherEntity?.let { publisherEntityMapper.mapToDomain(it) },
        entity.originUrl,
        entity.avatarEntity?.let { avatarEntityMapper.mapToDomain(it) },
        entity.imagesEntity?.let { it.map { imageEntityMapper.mapToDomain(it) } },
        entity.content
    )

    override fun mapToEntity(model: NewsFeed) = NewFeedEntity(
        model.documentId, model.title, model.description, model.contentType, model.publishedDate,
        model.publisher?.let { publisherEntityMapper.mapToEntity(it) },
        model.originUrl,
        model.avatar?.let { avatarEntityMapper.mapToEntity(it) },
        model.images?.let { it.map { imageEntityMapper.mapToEntity(it) } },
        model.content
    )
}

