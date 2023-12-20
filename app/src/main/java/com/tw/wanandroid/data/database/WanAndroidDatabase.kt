package com.tw.wanandroid.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tw.wanandroid.data.database.dao.BooksDao
import com.tw.wanandroid.data.database.table.BooksTable

/**
 *
 * @author TW,uidq3844
 * Time: 2023-8-29 20:38
 * Description:
 *
 * Copyright (c) 2023 Desaysv All rights reserved.
 */
@Database(version = 1, entities = [BooksTable::class])
abstract class WanAndroidDatabase : RoomDatabase() {

    abstract fun booksDao(): BooksDao
}
