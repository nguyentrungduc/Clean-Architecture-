package com.example.cleanarchitecture.domain.repository

import com.example.cleanarchitecture.domain.model.DetailNewsFeed
import com.example.cleanarchitecture.domain.model.ListNewsFeed
import io.reactivex.Observable

interface NewsfeedRepository : Repository{
    fun getNewFeed(): Observable<ListNewsFeed>

    fun getDetailFeed(): Observable<DetailNewsFeed>
}