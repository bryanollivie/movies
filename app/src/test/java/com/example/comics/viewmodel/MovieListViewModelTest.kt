package com.example.comics.viewmodel

import app.cash.turbine.test
import com.example.comics.movie.domain.model.Movie
import com.example.comics.movie.domain.usecase.GetTrendingMoviesUseCase
import com.example.comics.movie.ui.features.movies.MovieListViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kotlin.test.assertTrue
import com.example.comics.movie.core.common.Result
import kotlin.test.Test

class MovieListViewModelTest {

    private val useCase = mockk<GetTrendingMoviesUseCase>()

    @Test
    fun `viewmodel emits loading then success`() = runTest {
        val movies = listOf(Movie(1, "Test Movie", "/path.jpg", 7.5.toString()))
        coEvery { useCase.invoke() } returns flowOf(Result.Success(movies))

        val viewModel = MovieListViewModel(useCase)

        viewModel.uiState.test {
            assertTrue(awaitItem() is Result.Loading)
            assertTrue(awaitItem() is Result.Success)
        }
    }
}
