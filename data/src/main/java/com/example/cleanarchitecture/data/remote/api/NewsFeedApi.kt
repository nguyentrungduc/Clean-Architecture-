package com.example.cleanarchitecture.data.remote.api

import com.example.cleanarchitecture.data.model.DetailNewsFeedEntity
import com.example.cleanarchitecture.data.model.ListNewsFeedEntity
import io.reactivex.Observable
import retrofit2.http.GET

interface NewsFeedApi {

    @GET("/Akaizz/static/master/newsfeed.json")
    fun getNewFeeds(): Observable<ListNewsFeedEntity>

    @GET("/Akaizz/static/master/detail.json")
    fun getDetailFeed(): Observable<DetailNewsFeedEntity>
}