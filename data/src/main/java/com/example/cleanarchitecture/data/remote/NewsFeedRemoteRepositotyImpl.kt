package com.example.cleanarchitecture.data.remote

import com.example.cleanarchitecture.data.model.*
import com.example.cleanarchitecture.data.remote.api.NewsFeedApi
import com.example.cleanarchitecture.domain.model.DetailNewsFeed
import com.example.cleanarchitecture.domain.model.ListNewsFeed
import com.example.cleanarchitecture.domain.repository.NewsfeedRepository
import com.google.gson.Gson
import io.reactivex.Observable
import javax.inject.Inject

class NewsFeedRemoteRepositotyImpl @Inject constructor(
    private val newsFeedApi: NewsFeedApi,
    private val listNewsNewFeedEntityMapper: ListNewsFeedEntityMapper,
    private val detailNewsFeedEntityMapper: DetailNewsFeedEntityMapper
) : NewsfeedRepository {

    override fun getNewFeed(): Observable<ListNewsFeed> {
        return Observable.create { observable ->
            observable.onNext(listNewsNewFeedEntityMapper.mapToDomain(getListNewsFeedEntity(getJson("newsfeed.json"))))
        }
//        return newsFeedApi.getNewFeeds()
//            .map { listNewsNewFeedEntityMapper.mapToDomain(it) }
    }

    override fun getDetailFeed(): Observable<DetailNewsFeed> {
        return Observable.create { observable ->
            observable.onNext(detailNewsFeedEntityMapper.mapToDomain(getDetailNewsFeedEntity(getJson("detail.json"))))
        }
//                return newsFeedApi.getDetailFeed()
//            .map { detailNewsFeedEntityMapper.mapToDomain(it) }
    }

    private fun getJson(fileName: String): String {
        val inputStream = javaClass.classLoader?.getResourceAsStream("api-response/$fileName")
        val out = StringBuilder()
        inputStream?.bufferedReader()?.useLines { lines ->
            lines.forEach { line ->
                out.append(line)
            }
        }
        return out.toString()
    }

    private fun getListNewsFeedEntity(json: String) : ListNewsFeedEntity {
        return Gson().fromJson(json, ListNewsFeedEntity::class.java)
    }

    private fun getDetailNewsFeedEntity(json: String) : DetailNewsFeedEntity {
        return Gson().fromJson(json, DetailNewsFeedEntity::class.java)
    }


}