package com.example.cleanarchitecture

import com.example.cleanarchitecture.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.realm.Realm
import io.realm.RealmConfiguration

class MainApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<MainApplication> = DaggerAppComponent.factory().create(this)

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder().name("realmDb").build()
        Realm.setDefaultConfiguration(config)
    }
}