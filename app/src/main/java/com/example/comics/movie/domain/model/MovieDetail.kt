package com.example.comics.movie.domain.model


data class MovieDetail(
    val id: Int = 0,
    val title: String? = "",
    val originalTitle: String? = "",
    val overview: String? = "",
    val backdropPath: String? = "",
    val posterPath: String? = "",
    val releaseDate: String? = "",
    val voteAverage: Double = 0.0,
    val voteCount: Int = 0,
    val adult: Boolean = false,
    val runtime: Int? = 0,
    val budget: Long? = 0,
    val revenue: Long? = 0,
    val status: String? = "",
    val homepage: String? = "",
    val tagline: String? = "",
    val genres: List<Genre>? = null,
    val belongsToCollection: BelongsToCollection? = null,
    val productionCompanies: List<ProductionCompany>? = null,
    val productionCountries: List<ProductionCountry>? = null,
    val spokenLanguages: List<SpokenLanguage>? = null
)

data class Genre(val id: Int, val name: String)
data class BelongsToCollection(
    val id: Int,
    val name: String,
    val posterPath: String?,
    val backdropPath: String?
)

data class ProductionCompany(
    val id: Int,
    val logoPath: String?,
    val name: String,
    val originCountry: String
)

data class ProductionCountry(val iso: String, val name: String)
data class SpokenLanguage(val englishName: String, val iso: String, val name: String)
