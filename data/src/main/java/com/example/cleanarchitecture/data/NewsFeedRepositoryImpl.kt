package com.example.cleanarchitecture.data

import com.example.cleanarchitecture.data.local.NewsFeedLocalRepositoryImpl
import com.example.cleanarchitecture.data.model.*
import com.example.cleanarchitecture.data.remote.NewsFeedRemoteRepositotyImpl
import com.example.cleanarchitecture.domain.model.DetailNewsFeed
import com.example.cleanarchitecture.domain.model.ListNewsFeed
import com.example.cleanarchitecture.domain.repository.NewsfeedRepository
import io.reactivex.Observable
import javax.inject.Inject

class NewsFeedRepositoryImpl @Inject constructor(
    private val newsFeedRemoteRepositotyImpl: NewsFeedRemoteRepositotyImpl,
    private val newsFeedLocalRepositoryImpl: NewsFeedLocalRepositoryImpl,
    private val listNewsNewFeedEntityMapper: ListNewsFeedEntityMapper,
    private val detailNewsFeedEntityMapper: DetailNewsFeedEntityMapper
) : NewsfeedRepository {

    override fun getNewFeed(): Observable<ListNewsFeed> {
      return newsFeedRemoteRepositotyImpl.getNewFeed()
    }

    override fun getDetailFeed(): Observable<DetailNewsFeed> {
        return newsFeedRemoteRepositotyImpl.getDetailFeed()
    }

}