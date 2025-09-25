package com.example.comics.movie.domain.usecase

import com.example.comics.movie.data.repository.MovieRepository
import com.example.comics.movie.domain.model.MovieDetail
import com.example.comics.movie.core.common.Result
import kotlinx.coroutines.flow.Flow

class GetMovieDetailUseCase(
    private val repository: MovieRepository
) {
    operator fun invoke(movieId: Int): Flow<Result<MovieDetail>> {
        return repository.getMovieDetail(movieId)
    }
}
