package com.example.comics.movie.domain.model

data class Movie(
    val id: Int? = 0,
    val title: String? = "",
    val originalTitle: String?= "",
    val overview: String?= "",
    val backdropPath: String?= "",
    val posterPath: String?= "",
    val releaseDate: String?= "",
    val voteAverage: String?= "",
    val voteCount: Int? = 1,
    val adult: Boolean = false,
    val genreIds: List<Int>? = null,
    val popularity: String?= "",
) {
    val backdropUrl: String?
        get() = backdropPath?.let { "https://image.tmdb.org/t/p/w780$it" }

    val posterUrl: String?
        get() = posterPath?.let { "https://image.tmdb.org/t/p/w500$it" }
}