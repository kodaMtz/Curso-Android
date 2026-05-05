package com.example.bookshelf.data

import com.example.bookshelf.network.BookVolumeDetail

interface BooksRepository {
    suspend fun getBooks(query: String): List<BookVolumeDetail>
}