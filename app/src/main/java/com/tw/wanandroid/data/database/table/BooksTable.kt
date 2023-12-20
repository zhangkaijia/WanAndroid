package com.tw.wanandroid.data.database.table

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * @author TW,uidq3844
 * Time: 2023-8-29 20:10
 * Description:
 * 数据库图书表
 *
 * Copyright (c) 2023 Desaysv All rights reserved.
 */
@Entity(tableName = "db_books")
data class BooksTable(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val author: String
)