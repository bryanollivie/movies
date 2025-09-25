package com.example.comics.movie.core.network

import com.example.comics.movie.data.remote.model.MovieDetailResponseDto
import com.example.comics.movie.data.remote.model.MovieResponseDto
import com.example.comics.movie.domain.model.MovieDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {
    @GET("trending/movie/day")
    suspend fun getTrendingMovies(): MovieResponseDto

    @GET("movie/{movieId}")
    suspend fun getMovieDetail(
        @Path("movieId") movieId: Int,
        @Query("language") language: String = "en-US"
    ): MovieDetailResponseDto


}