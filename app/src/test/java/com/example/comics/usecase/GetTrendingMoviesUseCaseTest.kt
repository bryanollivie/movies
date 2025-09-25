package com.example.comics.usecase

import app.cash.turbine.test
import com.example.comics.movie.data.repository.MovieRepository
import com.example.comics.movie.domain.model.Movie
import com.example.comics.movie.domain.usecase.GetTrendingMoviesUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import com.example.comics.movie.core.common.Result
import org.junit.Test
import kotlin.test.assertTrue

class GetTrendingMoviesUseCaseTest {

    private val repository = mockk<MovieRepository>()
    private val useCase = GetTrendingMoviesUseCase(repository)

    @Test
    fun `when repository returns success, usecase emits success`() = runTest {
        val movies = listOf(Movie(1, "Test Movie", "/path.jpg", 7.5.toString()))
        coEvery { repository.getTrendingMovies() } returns flowOf(Result.Success(movies))

        useCase().test {
            val emission = awaitItem()
            assertTrue (emission is Result.Success && emission.data.size == 1)
            awaitComplete()
        }
    }
}
