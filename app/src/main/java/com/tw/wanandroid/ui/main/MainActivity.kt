package com.tw.wanandroid.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.tw.wanandroid.R
import com.tw.wanandroid.data.database.table.BooksTable
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        val TAG: String = Companion::class.java.simpleName
    }

    private val viewModel: MainViewModel by viewModel()
    private lateinit var btnGetData: Button
    private lateinit var tvContent: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Log.d(TAG, "onCreate: ${secondName!!.length}")
        setContentView(R.layout.activity_test)

        btnGetData = findViewById(R.id.btnGetData)
        tvContent = findViewById(R.id.tvContent)

        viewModel.deleteAll()

        btnGetData.setOnClickListener {
            viewModel.addBook(BooksTable(2222, "sdsdsdsds", "wwwwwwwwwwww"))
            viewModel.getBookList()
        }

        viewModel.booksListLiveData.observe(this){
            Log.i(MainViewModel.TAG, "getBookList: wwwww${Thread.currentThread().name}")
            tvContent.text = it[0].name
        }


    }
}