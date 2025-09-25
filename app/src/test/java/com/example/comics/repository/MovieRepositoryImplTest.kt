package com.example.comics.repository

import app.cash.turbine.test
import com.example.comics.movie.core.network.MovieApiService
import com.example.comics.movie.data.remote.model.MovieDto
import com.example.comics.movie.data.remote.model.MovieResponseDto
import com.example.comics.movie.data.repository.MovieRepositoryImpl
import kotlinx.coroutines.test.runTest
import io.mockk.coEvery
import io.mockk.mockk
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlinx.coroutines.flow.first
import kotlin.test.Test
import com.example.comics.movie.core.common.Result

class MovieRepositoryImplTest {

    private val api = mockk<MovieApiService>()
    private val repository = MovieRepositoryImpl(api)

    @Test
    fun `repository maps dto to domain model correctly`() = runTest {
        val dto = MovieDto(
            1, "Test", "/poster.jpg", "Overview", "/backdrop.jpg", "7.5.toString()",
            releaseDate = "",
            voteAverage = "",
            voteCount = 1,
            adult = false,
            genreIds = null,
            popularity = "",
            video = false,
            mediaType = "",
            originalLanguage = ""
        )
        val response = MovieResponseDto(
            1, listOf(dto),
            totalPages = 1,
            totalResults = 1
        )
        coEvery { api.getTrendingMovies() } returns response

        val result = repository.getTrendingMovies().first()
        assertTrue(result is Result.Success)
        assertEquals("Test", (result as Result.Success).data[0].title)
    }
}
