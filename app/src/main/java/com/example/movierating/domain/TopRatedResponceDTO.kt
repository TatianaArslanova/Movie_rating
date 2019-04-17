package com.example.movierating.domain

import com.google.gson.annotations.SerializedName

data class TopRatedResponceDTO(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val movies: List<MovieDTO>
)