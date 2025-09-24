package com.example.comics.movie.data.repository

import com.example.comics.movie.core.common.Result
import com.example.comics.movie.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getTrendingMovies(): Flow<Result<List<Movie>>>
}