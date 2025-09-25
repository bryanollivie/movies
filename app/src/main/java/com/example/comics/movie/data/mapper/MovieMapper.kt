package com.example.comics.movie.data.mapper

import com.example.comics.movie.data.remote.model.MovieDetailResponseDto
import com.example.comics.movie.data.remote.model.MovieDto
import com.example.comics.movie.domain.model.BelongsToCollection
import com.example.comics.movie.domain.model.Genre
import com.example.comics.movie.domain.model.Movie
import com.example.comics.movie.domain.model.MovieDetail
import com.example.comics.movie.domain.model.ProductionCompany
import com.example.comics.movie.domain.model.ProductionCountry
import com.example.comics.movie.domain.model.SpokenLanguage

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

fun MovieDetailResponseDto.toDomainModel(): MovieDetail {
    return MovieDetail(
        id = id,
        title = title,
        originalTitle = originalTitle,
        overview = overview,
        backdropPath = backdropPath,
        posterPath = posterPath,
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        voteCount = voteCount,
        adult = adult,
        runtime = runtime,
        budget = budget,
        revenue = revenue,
        status = status,
        homepage = homepage,
        tagline = tagline,
        genres = genres.map { Genre(it.id, it.name) },
        belongsToCollection = belongsToCollection?.let {
            BelongsToCollection(it.id, it.name, it.posterPath, it.backdropPath)
        },
        productionCompanies = productionCompanies.map {
            ProductionCompany(it.id, it.logoPath, it.name, it.originCountry)
        },
        productionCountries = productionCountries.map {
            ProductionCountry(it.iso, it.name)
        },
        spokenLanguages = spokenLanguages.map {
            SpokenLanguage(it.englishName, it.iso, it.name)
        }
    )
}

