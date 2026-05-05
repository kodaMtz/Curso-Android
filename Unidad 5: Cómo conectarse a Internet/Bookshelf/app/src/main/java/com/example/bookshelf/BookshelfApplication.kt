package com.example.bookshelf

import android.app.Application
import com.example.bookshelf.data.BooksRepository
import com.example.bookshelf.data.NetworkBooksRepository
import com.example.bookshelf.network.RetrofitInstance

class BookshelfApplication : Application() {
    lateinit var container: BooksRepository

    override fun onCreate() {
        super.onCreate()
        container = NetworkBooksRepository(RetrofitInstance.api)
    }
}