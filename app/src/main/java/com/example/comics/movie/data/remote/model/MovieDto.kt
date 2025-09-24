package com.example.comics.movie.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDto(
    @SerialName("id")
    val id: Int?,
    @SerialName("title")
    val title: String?,

    @SerialName("original_title")
    val originalTitle: String?,

    @SerialName("overview")
    val overview: String?,

    @SerialName("backdrop_path")
    val backdropPath: String? = null,

    @SerialName("poster_path")
    val posterPath: String? = null,

    @SerialName("release_date")
    val releaseDate: String?,

    @SerialName("vote_average")
    val voteAverage:String?,
    @SerialName("vote_count")
    val voteCount: Int?,

    @SerialName("adult")
    val adult: Boolean?,

    @SerialName("genre_ids")
    val genreIds: List<Int>?,

    @SerialName("popularity")
    val popularity: String?,

    @SerialName("video")
    val video: Boolean?,

    @SerialName("media_type")
    val mediaType: String? = null,

    @SerialName("original_language")
    val originalLanguage: String?
)