package com.example.cleanarchitecture.domain.usecase.newsfeed

import com.example.cleanarchitecture.domain.model.ListNewsFeed
import com.example.cleanarchitecture.domain.repository.NewsfeedRepository
import com.example.cleanarchitecture.domain.usecase.UseCase
import io.reactivex.Observable
import javax.inject.Inject

open class NewsFeedUseCases @Inject constructor(
    private val newsfeedRepository: NewsfeedRepository
) : UseCase<NewsFeedUseCases.Params, Observable<ListNewsFeed>>() {
    override fun createObservable(params: Params?): Observable<ListNewsFeed> {
        return newsfeedRepository.getNewFeed(params?.isConnected ?: true)
    }

    override fun onCleared() {
    }

    data class Params(val isConnected: Boolean)
}