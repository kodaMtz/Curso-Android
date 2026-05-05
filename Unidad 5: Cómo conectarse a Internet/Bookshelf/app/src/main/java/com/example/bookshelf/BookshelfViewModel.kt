package com.example.bookshelf

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.data.BooksRepository
import com.example.bookshelf.network.BookVolumeDetail
import kotlinx.coroutines.launch

sealed interface BookshelfUiState {
    data class Success(val books: List<BookVolumeDetail>) : BookshelfUiState
    object Error : BookshelfUiState
    object Loading : BookshelfUiState
}

class BookshelfViewModel(
    private val booksRepository: BooksRepository
) : ViewModel() {

    var uiState: BookshelfUiState by mutableStateOf(BookshelfUiState.Loading)
        private set

    init {
        getBooks()
    }

    fun getBooks(query: String = "android") {
        viewModelScope.launch {
            uiState = BookshelfUiState.Loading
            uiState = try {
                val books = booksRepository.getBooks(query)
                BookshelfUiState.Success(books)
            } catch (e: Exception) {
                e.printStackTrace()
                android.util.Log.e("BookshelfVM", "Error: ${e.message}", e)
                BookshelfUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BookshelfApplication)
                BookshelfViewModel(application.container)
            }
        }
    }
}