package com.tw.wanandroid

import android.app.Application
import com.tw.wanandroid.di.dbModule
import com.tw.wanandroid.di.repositoryModule
import com.tw.wanandroid.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class WanAppliction : Application() {

    override fun onCreate() {
        super.onCreate()


        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@WanAppliction)
            modules(listOf(dbModule, repositoryModule, viewModelModule))
        }
    }


}