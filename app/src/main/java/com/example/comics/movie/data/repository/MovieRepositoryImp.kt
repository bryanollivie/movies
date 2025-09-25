package com.example.comics.movie.data.repository

import com.example.comics.BuildConfig
import com.example.comics.movie.core.common.Result
import com.example.comics.movie.core.network.HttpErrorHandler
import com.example.comics.movie.core.network.MovieApiService
import com.example.comics.movie.data.mapper.toDomainModel
import com.example.comics.movie.data.remote.model.MovieDetailResponseDto
import com.example.comics.movie.domain.model.Movie
import com.example.comics.movie.domain.model.MovieDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApiService
) : MovieRepository {

    override fun getTrendingMovies(): Flow<Result<List<Movie>>> = flow {

        emit(Result.Loading)
        try {
            val response = api.getTrendingMovies()

            emit(Result.Success(response.results.map {
                it.toDomainModel()
            }))
        } catch (e: HttpException) {

            emit(Result.Error(HttpErrorHandler.fromCode(e.code())))
        }

    }.flowOn(Dispatchers.IO)

    override fun getMovieDetail(movieId: Int): Flow<Result<MovieDetail>> = flow {

        emit(Result.Loading)

        try {
            val response = api.getMovieDetail(movieId)

            emit(Result.Success(response.toDomainModel()))

        } catch (e: HttpException) {

            emit(Result.Error(HttpErrorHandler.fromCode(e.code())))
        }


    }.flowOn(Dispatchers.IO) as Flow<Result<MovieDetail>>
}
