package com.example.cleanarchitecture.data.local

import com.example.cleanarchitecture.data.model.DetailNewsFeedEntityMapper
import com.example.cleanarchitecture.data.model.ListNewsFeedEntityMapper
import com.example.cleanarchitecture.domain.model.DetailNewsFeed
import com.example.cleanarchitecture.domain.model.ListNewsFeed
import com.example.cleanarchitecture.domain.repository.NewsfeedRepository
import io.reactivex.Observable
import javax.inject.Inject

class NewsFeedLocalRepositoryImpl @Inject constructor(
    private val listNewsNewFeedEntityMapper: ListNewsFeedEntityMapper,
    private val detailNewsFeedEntityMapper: DetailNewsFeedEntityMapper
) : NewsfeedRepository {

    override fun getNewFeed(): Observable<ListNewsFeed> {
        TODO("Not yet implemented")
    }

    override fun getDetailFeed(): Observable<DetailNewsFeed> {
        TODO("Not yet implemented")
    }


}