package com.example.cleanarchitecture.domain.model

data class NewsFeed(val documentId: String?,
                    val title: String?,
                    val description: String?,
                    val contentType: String?,
                    val publishedDate: String?,
                    val publisher: Publisher?,
                    val originUrl: String?,
                    val avatar: Avatar?,
                    val images: List<Image>?,
                    val content: Any?): Model()
