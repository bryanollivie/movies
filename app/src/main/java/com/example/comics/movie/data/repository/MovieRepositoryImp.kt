package com.example.comics.movie.data.repository

import com.example.comics.movie.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.example.comics.movie.data.mapper.toDomainModel
import com.example.comics.movie.core.common.Result
import com.example.comics.movie.core.network.MovieApiService

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApiService
) : MovieRepository {

    override fun getTrendingMovies(): Flow<Result<List<Movie>>> = flow {

        emit(Result.Loading)

        val response = api.getTrendingMovies()

        emit(Result.Success(response.results.map {
            it.toDomainModel()
        }))
    }.catch { e ->
        emit(Result.Error(e))
    }
}
