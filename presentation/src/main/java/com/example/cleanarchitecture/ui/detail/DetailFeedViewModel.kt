package com.example.cleanarchitecture.ui.detail

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecture.base.BaseViewModel
import com.example.cleanarchitecture.domain.usecase.newsfeed.NewsFeedDetailUseCase
import com.example.cleanarchitecture.extension.add
import com.example.cleanarchitecture.model.DetailNewsFeedItem
import com.example.cleanarchitecture.model.DetailNewsFeedItemMapper
import javax.inject.Inject

class DetailFeedViewModel @Inject constructor(
    private val detailNewFeedItemMapper: DetailNewsFeedItemMapper,
    private val detailNewsFeedUseCases: NewsFeedDetailUseCase
) : BaseViewModel() {

    val detail = MutableLiveData<DetailNewsFeedItem>()

    fun getDetailFeed() {
        detailNewsFeedUseCases.createObservable(NewsFeedDetailUseCase.Params())
            .map {
                detailNewFeedItemMapper.mapToPresentation(it)
            }
            .subscribe({ detail.value = it }, {
                setThrowable(it)
            })
            .add(this)
    }

    @VisibleForTesting
    fun clear() {
        super.onCleared()
    }
}