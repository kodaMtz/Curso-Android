package com.example.bookshelf.data

import com.example.bookshelf.network.BookVolumeDetail
import com.example.bookshelf.network.BooksApiService
import com.example.bookshelf.network.ImageLinks
import com.example.bookshelf.network.VolumeInfo

class NetworkBooksRepository(
    private val booksApiService: BooksApiService
) : BooksRepository {

    override suspend fun getBooks(query: String): List<BookVolumeDetail> {
        return listOf(
            BookVolumeDetail("1", VolumeInfo("Kotlin Programming", ImageLinks("https://picsum.photos/seed/book1/200/300"))),
            BookVolumeDetail("2", VolumeInfo("Android Development", ImageLinks("https://picsum.photos/seed/book2/200/300"))),
            BookVolumeDetail("3", VolumeInfo("Jetpack Compose", ImageLinks("https://picsum.photos/seed/book3/200/300"))),
            BookVolumeDetail("4", VolumeInfo("Clean Architecture", ImageLinks("https://picsum.photos/seed/book4/200/300"))),
            BookVolumeDetail("5", VolumeInfo("Design Patterns", ImageLinks("https://picsum.photos/seed/book5/200/300"))),
            BookVolumeDetail("6", VolumeInfo("Coroutines in Kotlin", ImageLinks("https://picsum.photos/seed/book6/200/300"))),
            BookVolumeDetail("7", VolumeInfo("MVVM Architecture", ImageLinks("https://picsum.photos/seed/book7/200/300"))),
            BookVolumeDetail("8", VolumeInfo("REST APIs with Retrofit", ImageLinks("https://picsum.photos/seed/book8/200/300")))
        )
    }
}