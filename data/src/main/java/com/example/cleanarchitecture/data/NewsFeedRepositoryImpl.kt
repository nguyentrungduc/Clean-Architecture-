package com.example.cleanarchitecture.data

import com.example.cleanarchitecture.data.model.DetailNewsFeedEntityMapper
import com.example.cleanarchitecture.data.model.ListNewsFeedEntityMapper
import com.example.cleanarchitecture.data.model.NewsFeedEntity
import com.example.cleanarchitecture.data.model.NewsFeedEntityMapper
import com.example.cleanarchitecture.data.remote.api.NewsFeedApi
import com.example.cleanarchitecture.domain.model.DetailNewsFeed
import com.example.cleanarchitecture.domain.model.ListNewsFeed
import com.example.cleanarchitecture.domain.model.NewsFeed
import com.example.cleanarchitecture.domain.repository.NewsfeedRepository
import io.reactivex.Observable
import io.realm.Realm
import io.realm.kotlin.where
import javax.inject.Inject


class NewsFeedRepositoryImpl @Inject constructor(
    private val newsFeedApi: NewsFeedApi,
    private val newsFeedEntityMapper: NewsFeedEntityMapper,
    private val listNewsNewFeedEntityMapper: ListNewsFeedEntityMapper,
    private val detailNewsFeedEntityMapper: DetailNewsFeedEntityMapper
) : NewsfeedRepository {
    override fun getNewFeed(isConnected: Boolean): Observable<ListNewsFeed> {
        val localSource = Observable.just(
            listNewsNewFeedEntityMapper.mapListNewsFeed(
                Realm.getDefaultInstance().where<NewsFeedEntity>().findAll()
            )
        )
        return if (isConnected) Observable.concat(localSource,
            newsFeedApi.getNewFeeds().map {
                listNewsNewFeedEntityMapper.mapToDomain(it)
            }.doOnNext {
                    it.listNewsFeed?.let { listNewsFeed ->
                        saveListNewFeed(listNewsFeed)
                    }
                }
        ) else return localSource
    }

    override fun getDetailFeed(): Observable<DetailNewsFeed> {
        return newsFeedApi.getDetailFeed().map {
            detailNewsFeedEntityMapper.mapToDomain(it)
        }
    }

    override fun saveListNewFeed(listNewsFeed: List<NewsFeed>) {
        with(Realm.getDefaultInstance()) {
            beginTransaction()
            listNewsFeed.forEach {
                insertOrUpdate(newsFeedEntityMapper.mapToEntity(it))
            }
            commitTransaction()
        }
    }

}