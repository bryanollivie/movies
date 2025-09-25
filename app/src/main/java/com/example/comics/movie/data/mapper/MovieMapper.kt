package com.example.comics.movie.data.mapper

import com.example.comics.movie.data.remote.model.MovieDto
import com.example.comics.movie.domain.model.Movie


fun MovieDto.toDomainModel(): Movie {
    return Movie(
        id = id,
        title = title,
        originalTitle = originalTitle,
        overview = overview,
        backdropPath = backdropPath,
        posterPath = posterPath,
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        voteCount = voteCount,
        adult = adult == false,
        genreIds = genreIds,
        popularity = popularity
    )
}
