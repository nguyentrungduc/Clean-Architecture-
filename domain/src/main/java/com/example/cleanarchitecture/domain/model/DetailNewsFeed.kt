package com.example.cleanarchitecture.domain.model

class DetailNewsFeed(val documentId: String?,
                    val title: String?,
                    val description: String?,
                    val publishedDate: String?,
                    val originUrl: String?,
                    val publisher: Publisher?,
                    val templateType: String?,
                    val sectionEntities: List<Section>?): Model() {
}