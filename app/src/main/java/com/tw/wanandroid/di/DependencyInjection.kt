package com.tw.wanandroid.di

import androidx.room.Room
import com.tw.wanandroid.data.constants.DB_WAN_ANDROID
import com.tw.wanandroid.data.database.WanAndroidDatabase
import com.tw.wanandroid.data.repository.BookRepository
import com.tw.wanandroid.ui.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
 *
 * @author TW,uidq3844
 * Time: 2023-12-18 16:18
 * Description:
 *
 * Copyright (c) 2023 Desaysv All rights reserved.
 */


val dbModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            WanAndroidDatabase::class.java,
            DB_WAN_ANDROID
        ).build()
    }
}

val repositoryModule = module {
    factory {
      BookRepository(get())
    }
}


val viewModelModule= module {
    viewModel{
        MainViewModel(get())
    }
}