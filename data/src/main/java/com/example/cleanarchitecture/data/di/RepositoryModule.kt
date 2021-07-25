package com.example.cleanarchitecture.data.di

import com.example.cleanarchitecture.data.*
import com.example.cleanarchitecture.domain.repository.NewsfeedRepository
import dagger.Module
import dagger.Provides
import io.realm.Realm
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRealmDatabase(): Realm {
        return Realm.getDefaultInstance()
    }

    @Provides
    @Singleton
    fun providerNewFeedRepository(repository: NewsFeedRepositoryImpl): NewsfeedRepository {
        return repository
    }
}
