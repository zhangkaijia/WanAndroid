package com.tw.wanandroid.ui.main

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tw.wanandroid.data.database.table.BooksTable
import com.tw.wanandroid.data.repository.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.logger.Logger
import java.lang.Exception

/**
 *
 * @author TW,uidq3844
 * Time: 2023-8-28 20:20
 * Description:
 *
 * Copyright (c) 2023 Desaysv All rights reserved.
 */
class MainViewModel(private val repository: BookRepository) : ViewModel() {

    companion object {
        @JvmStatic
        val TAG: String = MainViewModel::class.java.simpleName
    }

    val booksListLiveData: MutableLiveData<List<BooksTable>> = MutableLiveData()


    fun getBookList() {
        viewModelScope.launch {
            try {
              booksListLiveData.value = repository.getBooks()
                Log.i(TAG, "getBookList: ssssss${Thread.currentThread().name}")
            } catch (throwable: Throwable) {
                Log.e(TAG, "getBookList: ")
            }
        }
    }

    fun addBook(booksTable: BooksTable) {
        viewModelScope.launch {
            try {
                repository.addBook(booksTable)
            } catch (e: Exception) {
                Log.e(TAG, "addBook: error")
            }

        }
    }


    fun deleteAll(){
        viewModelScope.launch{
            try {
                repository.deleteAll()
            }catch (e:Exception){
                Log.e(TAG, "deleteAll: ")
            }
        }
    }



    override fun onCleared() {
        super.onCleared()
    }
}