package com.example.cleanarchitecture.data.remote

import com.example.cleanarchitecture.data.model.*
import com.example.cleanarchitecture.data.remote.api.NewsFeedApi
import com.example.cleanarchitecture.domain.model.DetailNewsFeed
import com.example.cleanarchitecture.domain.model.ListNewsFeed
import com.example.cleanarchitecture.domain.model.NewsFeed
import com.example.cleanarchitecture.domain.repository.NewsfeedRepository
import io.reactivex.Observable
import javax.inject.Inject


class NewsFeedRemoteRepositoryImpl @Inject constructor(
    private val newsFeedApi: NewsFeedApi,
    private val listNewsNewFeedEntityMapper: ListNewsFeedEntityMapper,
    private val detailNewsFeedEntityMapper: DetailNewsFeedEntityMapper
) : NewsfeedRepository {

    override fun getNewFeed(isConnected: Boolean): Observable<ListNewsFeed> {
        return newsFeedApi.getNewFeeds()
                .map {
                    listNewsNewFeedEntityMapper.mapToDomain(it)
                }
    }

    override fun getDetailFeed(): Observable<DetailNewsFeed> {
        return newsFeedApi.getDetailFeed().map {
            detailNewsFeedEntityMapper.mapToDomain(it)
        }
    }

    override fun saveListNewFeed(listNewsFeed: List<NewsFeed>) {
        TODO("Not yet implemented")
    }

}