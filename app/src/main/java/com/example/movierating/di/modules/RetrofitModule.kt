package com.example.movierating.di.modules

import android.util.Log
import com.example.movierating.BuildConfig
import com.example.movierating.data.MovieRatingApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideMovieRatingApi(retrofit: Retrofit.Builder): MovieRatingApi =
        retrofit.baseUrl(BuildConfig.BaseApiURL).build().create(MovieRatingApi::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit.Builder =
        Retrofit.Builder()
            .client(client)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideLoggingInterceptor() =
        HttpLoggingInterceptor { message -> Log.i("LOGGING_INTERCEPTOR", message) }
            .apply { level = HttpLoggingInterceptor.Level.BODY }
}