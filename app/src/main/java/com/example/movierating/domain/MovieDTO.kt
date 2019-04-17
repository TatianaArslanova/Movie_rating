package com.example.movierating.domain

import com.google.gson.annotations.SerializedName

data class MovieDTO(
    @SerializedName("id")
    val id: Long,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("original_title")
    val originalTitle: String?,
    @SerializedName("original_language")
    val originalLanguage: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("adult")
    val adult: Boolean?
)