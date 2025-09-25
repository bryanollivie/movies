package com.example.comics.movie.data.remote.model

import com.google.gson.annotations.SerializedName

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailResponseDto(
    val id: Int,
    val title: String,
    @SerialName("original_title") val originalTitle: String,
    val overview: String,
    @SerialName("backdrop_path") val backdropPath: String? = null,
    @SerialName("poster_path") val posterPath: String? = null,
    @SerialName("release_date") val releaseDate: String,
    @SerialName("vote_average") val voteAverage: Double,
    @SerialName("vote_count") val voteCount: Int,
    val adult: Boolean,
    val runtime: Int? = null,
    val budget: Long? = null,
    val revenue: Long? = null,
    val status: String? = null,
    val homepage: String? = null,
    val tagline: String? = null,
    @SerialName("belongs_to_collection") val belongsToCollection: BelongsToCollectionDto? = null,
    val genres: List<GenreDto> = emptyList(),
    @SerialName("production_companies") val productionCompanies: List<ProductionCompanyDto> = emptyList(),
    @SerialName("production_countries") val productionCountries: List<ProductionCountryDto> = emptyList(),
    @SerialName("spoken_languages") val spokenLanguages: List<SpokenLanguageDto> = emptyList()
)

@Serializable
data class GenreDto(val id: Int, val name: String)

@Serializable
data class BelongsToCollectionDto(
    val id: Int,
    val name: String,
    @SerialName("poster_path") val posterPath: String? = null,
    @SerialName("backdrop_path") val backdropPath: String? = null
)

@Serializable
data class ProductionCompanyDto(
    val id: Int,
    @SerialName("logo_path") val logoPath: String? = null,
    val name: String,
    @SerialName("origin_country") val originCountry: String
)

@Serializable
data class ProductionCountryDto(
    @SerialName("iso_3166_1") val iso: String,
    val name: String
)

@Serializable
data class SpokenLanguageDto(
    @SerialName("english_name") val englishName: String,
    @SerialName("iso_639_1") val iso: String,
    val name: String
)
