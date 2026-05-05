package com.example.bookshelf

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BookshelfViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var fakeRepository: FakeBooksRepository
    private lateinit var viewModel: BookshelfViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        fakeRepository = FakeBooksRepository()
        viewModel = BookshelfViewModel(fakeRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun bookshelfViewModel_getBooks_verifySuccess() = runTest {
        advanceUntilIdle()
        assertEquals(
            BookshelfUiState.Success(fakeRepository.fakeBooks),
            viewModel.uiState
        )
    }

    @Test
    fun bookshelfViewModel_initialState_isLoading() {
        assertEquals(
            BookshelfUiState.Loading,
            BookshelfUiState.Loading
        )
    }
}