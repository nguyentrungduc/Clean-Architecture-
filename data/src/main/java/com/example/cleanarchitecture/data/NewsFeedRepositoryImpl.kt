package com.example.cleanarchitecture.data

import com.example.cleanarchitecture.data.local.NewsFeedLocalRepositoryImpl
import com.example.cleanarchitecture.data.remote.NewsFeedRemoteRepositoryImpl
import com.example.cleanarchitecture.domain.model.DetailNewsFeed
import com.example.cleanarchitecture.domain.model.ListNewsFeed
import com.example.cleanarchitecture.domain.model.NewsFeed
import com.example.cleanarchitecture.domain.repository.NewsfeedRepository
import io.reactivex.Observable
import javax.inject.Inject


class NewsFeedRepositoryImpl @Inject constructor(
    private val newsFeedRemoteRepositoryImpl: NewsFeedRemoteRepositoryImpl,
    private val newsFeedLocalRepositoryImpl: NewsFeedLocalRepositoryImpl
) : NewsfeedRepository {
    override fun getNewFeed(): Observable<ListNewsFeed> {
        val local = newsFeedLocalRepositoryImpl.getNewFeed()
        val remote = newsFeedRemoteRepositoryImpl.getNewFeed().doOnNext {
            it.listNewsFeed?.let { listNewsFeed ->
                newsFeedLocalRepositoryImpl.saveListNewFeed(listNewsFeed)
            }
        }
        return Observable.concat(local, remote)
    }

    override fun getDetailFeed(): Observable<DetailNewsFeed> {
        return newsFeedRemoteRepositoryImpl.getDetailFeed()
    }

    override fun saveListNewFeed(listNewsFeed: List<NewsFeed>) {
        newsFeedLocalRepositoryImpl.saveListNewFeed(listNewsFeed)
    }

}