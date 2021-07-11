package com.example.cleanarchitecture.domain.model

data class Content(
    val href: String?,
    val caption: String?,
    val duration: Int?,
    val previewImageEntity: Image?,
    val text: String?,
    val markupEntities: List<Markup>?,
    val mainColor: String?,
    val originalWidth: Int?,
    val originalHeight: Int?
): Model()