package com.example.bookshelf.network

import com.google.gson.annotations.SerializedName

data class BookSearchResponse(
    @SerializedName("items") val items: List<BookVolumeDetail> = emptyList()
)

data class BookVolume(
    @SerializedName("id") val id: String
)

data class BookVolumeDetail(
    @SerializedName("id") val id: String = "",
    @SerializedName("volumeInfo") val volumeInfo: VolumeInfo = VolumeInfo()
)

data class VolumeInfo(
    @SerializedName("title") val title: String = "",
    @SerializedName("imageLinks") val imageLinks: ImageLinks? = null
)

data class ImageLinks(
    @SerializedName("thumbnail") val thumbnail: String = ""
)