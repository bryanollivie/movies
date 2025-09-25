package com.example.comics.movie.core.di

import com.example.comics.movie.data.repository.MovieRepository
import com.example.comics.movie.domain.usecase.GetMovieDetailUseCase
import com.example.comics.movie.domain.usecase.GetTrendingMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetTrendingMoviesUseCase(repository: MovieRepository): GetTrendingMoviesUseCase {
        return GetTrendingMoviesUseCase(repository)
    }

    @Provides
    fun provideGetMovieDetailUseCase(repository: MovieRepository): GetMovieDetailUseCase {
        return GetMovieDetailUseCase(repository)
    }

}