package com.example.cleanarchitecture.di.builder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.ViewModelProviderFactory
import com.example.cleanarchitecture.di.annotation.ViewModelKey
import com.example.cleanarchitecture.ui.detail.DetailFeedViewModel
import com.example.cleanarchitecture.ui.home.HomeViewModel
import com.example.cleanarchitecture.ui.newsfeed.NewsFeedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(providerFactory: ViewModelProviderFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewsFeedViewModel::class)
    abstract fun bindNewsFeedViewModel(newsFeedViewModel: NewsFeedViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailFeedViewModel::class)
    abstract fun bindDetailFeedViewModel(detailFeedViewModel: DetailFeedViewModel): ViewModel
}