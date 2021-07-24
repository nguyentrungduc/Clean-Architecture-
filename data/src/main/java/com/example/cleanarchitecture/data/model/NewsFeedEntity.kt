package com.example.cleanarchitecture.data.model

import com.example.cleanarchitecture.data.base.RealmEntityMapper
import com.example.cleanarchitecture.domain.model.Image
import com.example.cleanarchitecture.domain.model.NewsFeed
import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.Ignore
import io.realm.annotations.PrimaryKey
import javax.inject.Inject


open class NewsFeedEntity(
    @PrimaryKey
    var primaryKey: String? = null,
    @SerializedName("document_id")
    var documentId: String = "",
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("content_type")
    var contentType: String? = null,
    @SerializedName("published_date")
    var publishedDate: String? = null,
    @SerializedName("publisher")
    var publisherEntity: PublisherEntity? = null,
    @SerializedName("origin_url")
    var originUrl: String? = null,
    @SerializedName("avatar")
    var avatarEntity: AvatarEntity? = null,
    @SerializedName("images")
    var imagesEntity: RealmList<ImageEntity>? = null,
    @Ignore
    @SerializedName("content")
    var content: Any? = null
) : RealmObject() {
    constructor() : this(null,"", null, null,null, null, null, null,null, null, null)
    init {
        primaryKey = documentId + title
    }
}

class NewsFeedEntityMapper @Inject constructor(private val publisherEntityMapper: PublisherEntityMapper,
                                               private val avatarEntityMapper: AvatarEntityMapper,
                                               private val imageEntityMapper: ImageEntityMapper)
    : RealmEntityMapper<NewsFeed, NewsFeedEntity> {

    override fun mapToDomain(entity: NewsFeedEntity) = NewsFeed(
        entity.documentId, entity.title, entity.description, entity.contentType, entity.publishedDate,
        entity.publisherEntity?.let { publisherEntityMapper.mapToDomain(it) },
        entity.originUrl,
        entity.avatarEntity?.let { avatarEntityMapper.mapToDomain(it) },
        entity.imagesEntity?.let { it.map { imageEntityMapper.mapToDomain(it) } },
        entity.content
    )

    override fun mapToEntity(model: NewsFeed) = NewsFeedEntity(model.documentId + model.title,
        model.documentId, model.title, model.description, model.contentType, model.publishedDate,
        model.publisher?.let { publisherEntityMapper.mapToEntity(it) },
        model.originUrl,
        model.avatar?.let { avatarEntityMapper.mapToEntity(it) },
        model.images?.let { parseToRealmList(it, imageEntityMapper) },
        model.content
    )

    private fun parseToRealmList(listImage: List<Image>, imageEntityMapper: ImageEntityMapper): RealmList<ImageEntity> {
        val list = RealmList<ImageEntity>()
        listImage.forEach {
            list.add(imageEntityMapper.mapToEntity(it))
        }
        return list
    }
}

