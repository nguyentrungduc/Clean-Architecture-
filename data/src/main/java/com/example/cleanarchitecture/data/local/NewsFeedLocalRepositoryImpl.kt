package com.example.cleanarchitecture.data.local

import com.example.cleanarchitecture.data.model.ListNewsFeedEntityMapper
import com.example.cleanarchitecture.data.model.NewsFeedEntity
import com.example.cleanarchitecture.data.model.NewsFeedEntityMapper
import com.example.cleanarchitecture.domain.model.DetailNewsFeed
import com.example.cleanarchitecture.domain.model.ListNewsFeed
import com.example.cleanarchitecture.domain.model.NewsFeed
import com.example.cleanarchitecture.domain.repository.NewsfeedRepository
import io.reactivex.Observable
import io.realm.Realm
import io.realm.kotlin.where
import javax.inject.Inject

class NewsFeedLocalRepositoryImpl @Inject constructor(
    private val newsFeedEntityMapper: NewsFeedEntityMapper,
    private val listNewsNewFeedEntityMapper: ListNewsFeedEntityMapper
) : NewsfeedRepository {
    override fun getNewFeed(isConnected: Boolean): Observable<ListNewsFeed> {
        return Observable.just(listNewsNewFeedEntityMapper.mapListNewsFeed(Realm.getDefaultInstance().where<NewsFeedEntity>().findAll()))
    }

    override fun getDetailFeed(): Observable<DetailNewsFeed> {
        TODO("Not yet implemented")
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