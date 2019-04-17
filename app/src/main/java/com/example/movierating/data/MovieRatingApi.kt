package com.example.movierating.data

import com.example.movierating.BuildConfig
import com.example.movierating.domain.TopRatedResponceDTO
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieRatingApi {

    @GET("top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String = BuildConfig.ApiKeyV3): Deferred<TopRatedResponceDTO>

}