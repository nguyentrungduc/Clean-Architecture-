package com.example.cleanarchitecture.domain.usecase.newsfeed

import com.example.cleanarchitecture.domain.model.DetailNewsFeed
import com.example.cleanarchitecture.domain.repository.NewsfeedRepository
import com.example.cleanarchitecture.domain.usecase.UseCase
import io.reactivex.Observable
import javax.inject.Inject

open class NewsFeedDetailUseCase @Inject constructor(
    private val newsfeedRepository: NewsfeedRepository
) : UseCase<NewsFeedDetailUseCase.Params, Observable<DetailNewsFeed>>() {
    override fun createObservable(params: Params?): Observable<DetailNewsFeed> {
        return newsfeedRepository.getDetailFeed()
    }

    override fun onCleared() {
    }

    class Params()
}