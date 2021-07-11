package com.example.cleanarchitecture.di.builder

import com.example.cleanarchitecture.MainActivity
import com.example.cleanarchitecture.ui.detail.DetailFeedFragment
import com.example.cleanarchitecture.ui.home.HomeFragment
import com.example.cleanarchitecture.ui.newsfeed.NewsfeedFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributeNewsFeedFragment(): NewsfeedFragment

    @ContributesAndroidInjector
    abstract fun contributeDetailFeedFragment(): DetailFeedFragment
}
