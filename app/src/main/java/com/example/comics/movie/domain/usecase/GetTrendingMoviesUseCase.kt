package com.example.comics.movie.domain.usecase

import com.example.comics.movie.data.repository.MovieRepository
import javax.inject.Inject

class GetTrendingMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke() = repository.getTrendingMovies()
}
