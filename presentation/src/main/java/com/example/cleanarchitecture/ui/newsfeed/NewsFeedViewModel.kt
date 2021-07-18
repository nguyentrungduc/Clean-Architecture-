package com.example.cleanarchitecture.ui.newsfeed

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecture.base.BaseViewModel
import com.example.cleanarchitecture.domain.usecase.newsfeed.NewsFeedUseCases
import com.example.cleanarchitecture.extension.add
import com.example.cleanarchitecture.model.ListNewsFeedItem
import com.example.cleanarchitecture.model.ListNewsFeedItemMapper
import com.example.cleanarchitecture.util.RxUtils
import javax.inject.Inject

class NewsFeedViewModel @Inject constructor(
    private val newsFeedUseCases: NewsFeedUseCases,
    private val listNewsFeedItemMapper: ListNewsFeedItemMapper
) : BaseViewModel() {

    val newsfeed = MutableLiveData<ListNewsFeedItem>()
    val loading = MutableLiveData<Boolean>().apply { postValue(false) }

    fun getNewsFeed() {
        newsFeedUseCases.createObservable(NewsFeedUseCases.Params())
            .compose(RxUtils.applyObservableScheduler(loading))
            .doFinally { loading.value = false }
            .map {
                listNewsFeedItemMapper.mapToPresentation(it)
            }
            .subscribe(
                {
                    loading.value = false
                    newsfeed.value = it
                }, {
                    setThrowable(it)
                })
            .add(this)
    }

    @VisibleForTesting
    fun clear() {
        super.onCleared()
    }
}