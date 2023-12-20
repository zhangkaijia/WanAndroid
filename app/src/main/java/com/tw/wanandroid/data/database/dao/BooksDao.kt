package com.tw.wanandroid.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query
import com.tw.wanandroid.data.database.table.BooksTable
import java.util.concurrent.Flow

/**
 *
 * @author TW,uidq3844
 * Time: 2023-8-29 20:30
 * Description:
 *
 * Copyright (c) 2023 Desaysv All rights reserved.
 */

@Dao
interface BooksDao {
    @Insert
    fun insert(books: BooksTable): Long

    @Query("select * from db_books")
    fun getAll():List<BooksTable>

    @Query("delete from db_books")
    fun deleteAll()
}