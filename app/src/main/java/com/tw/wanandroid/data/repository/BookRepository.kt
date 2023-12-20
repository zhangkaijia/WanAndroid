package com.tw.wanandroid.data.repository

import android.util.Log
import com.tw.wanandroid.data.database.WanAndroidDatabase
import com.tw.wanandroid.data.database.dao.BooksDao
import com.tw.wanandroid.data.database.table.BooksTable
import com.tw.wanandroid.ui.main.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

/**
 *
 * @author TW,uidq3844
 * Time: 2023-8-29 20:12
 * Description:
 *
 * Copyright (c) 2023 Desaysv All rights reserved.
 */
class BookRepository(database: WanAndroidDatabase) {
    companion object {
        @JvmStatic
        val TAG: String = BookRepository::class.java.simpleName
    }

    /** 账本数据库操作对象 */
    protected val booksDao: BooksDao by lazy {
        database.booksDao()
    }


    suspend fun addBook(booksTable: BooksTable) = withContext(Dispatchers.IO) {
        booksDao.insert(booksTable)
    }

    suspend fun getBooks(): List<BooksTable> = withContext(Dispatchers.IO) {
        Log.i(MainViewModel.TAG, "getBookList: qqqqqq${Thread.currentThread().name}")
        booksDao.getAll()
    }

    suspend fun deleteAll() = withContext(Dispatchers.IO) {
        booksDao.deleteAll()
    }

}