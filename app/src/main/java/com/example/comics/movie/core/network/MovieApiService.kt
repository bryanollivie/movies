package com.example.comics.movie.core.network

import com.example.comics.movie.data.remote.model.MovieResponseDto
import retrofit2.http.GET

interface MovieApiService {
    @GET("trending/movie/day")
    suspend fun getTrendingMovies(): MovieResponseDto

}