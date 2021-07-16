package com.example.cleanarchitecture.data.model


import com.example.cleanarchitecture.data.base.EntityMapper
import com.example.cleanarchitecture.data.base.ModelEntity
import com.example.cleanarchitecture.domain.model.Content
import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.annotations.Ignore
import javax.inject.Inject

open class ContentEntity(
    @SerializedName("href")
    val href: String?,
    @SerializedName("caption")
    val caption: String?,
    @SerializedName("duration")
    val duration: Int?,
    @SerializedName("preview_image")
    val previewImageEntity: ImageEntity?,
    @SerializedName("text")
    val text: String?,
    @Ignore
    @SerializedName("markups")
    val markupEntities: RealmList<MarkupEntity>?,
    @SerializedName("main_color")
    val mainColor: String?,
    @SerializedName("original_width")
    val originalWidth: Int?,
    @SerializedName("original_height")
    val originalHeight: Int?
) : ModelEntity()

class ContentEntityMapper @Inject constructor(
    private val imageEntityMapper: ImageEntityMapper,
    private val markupEntityMapper: MarkupEntityMapper
) : EntityMapper<Content, ContentEntity> {

    override fun mapToDomain(entity: ContentEntity) = Content(
        entity.href, entity.caption, entity.duration,
        entity.previewImageEntity?.let { imageEntityMapper.mapToDomain(it) },
        entity.text,
        entity.markupEntities?.let { it.map { markupEntityMapper.mapToDomain(it) } },
        entity.mainColor,
        entity.originalWidth,
        entity.originalHeight
    )

    override fun mapToEntity(model: Content) = ContentEntity(
        model.href, model.caption, model.duration,
        model.previewImageEntity?.let { imageEntityMapper.mapToEntity(it) },
        model.text,
        model.markupEntities?.let { it.map { markupEntityMapper.mapToEntity(it) } } as RealmList<MarkupEntity>?,
        model.mainColor,
        model.originalWidth,
        model.originalHeight
    )
}