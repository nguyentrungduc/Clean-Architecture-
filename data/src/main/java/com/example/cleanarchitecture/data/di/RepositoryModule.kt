package com.example.cleanarchitecture.data.di

import androidx.room.Room
import android.content.Context
import com.example.cleanarchitecture.data.*
import com.example.cleanarchitecture.data.local.db.AppDatabase
import com.example.cleanarchitecture.data.local.pref.AppPrefs
import com.example.cleanarchitecture.data.local.pref.PrefHelper
import com.example.cleanarchitecture.data.remote.NewsFeedRemoteRepositotyImpl
import com.example.cleanarchitecture.domain.repository.NewsfeedRepository
import com.example.cleanarchitecture.domain.repository.UserRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import io.realm.Realm
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @DatabaseInfo
    fun providerDatabaseName(): String {
        return Constants.DATABASE_NAME
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@DatabaseInfo dbName: String, context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, dbName).fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    @Singleton
    fun provideRealmDatabase(context: Context): Realm {
        return Realm.getDefaultInstance()
    }

    @Provides
    @Singleton
    fun providePrefHelper(appPrefs: AppPrefs): PrefHelper {
        return appPrefs
    }

    @Provides
    @Singleton
    fun providerAppPrefs(context: Context): AppPrefs {
        return AppPrefs(context, Gson())
    }

    @Provides
    @Singleton
    fun providerUserRepository(repository: UserRepositoryImpl): UserRepository {
        return repository
    }

    @Provides
    @Singleton
    fun providerNewFeedRepository(repository: NewsFeedRemoteRepositotyImpl): NewsfeedRepository {
        return repository
    }
}
