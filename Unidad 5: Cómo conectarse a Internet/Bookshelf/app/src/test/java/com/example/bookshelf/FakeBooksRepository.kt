package com.example.bookshelf

import com.example.bookshelf.data.BooksRepository
import com.example.bookshelf.network.BookVolumeDetail
import com.example.bookshelf.network.ImageLinks
import com.example.bookshelf.network.VolumeInfo

class FakeBooksRepository : BooksRepository {

    val fakeBooks = listOf(
        BookVolumeDetail(
            id = "1",
            volumeInfo = VolumeInfo(
                title = "Kotlin Programming",
                imageLinks = ImageLinks(thumbnail = "https://picsum.photos/seed/book1/200/300")
            )
        ),
        BookVolumeDetail(
            id = "2",
            volumeInfo = VolumeInfo(
                title = "Android Development",
                imageLinks = ImageLinks(thumbnail = "https://picsum.photos/seed/book2/200/300")
            )
        )
    )

    override suspend fun getBooks(query: String): List<BookVolumeDetail> {
        return fakeBooks
    }
}