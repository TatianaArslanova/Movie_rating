package com.example.movierating.presentation.list

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.movierating.data.MovieRatingApi
import com.example.movierating.presentation.list.mvp.MovieListView
import kotlinx.coroutines.*
import javax.inject.Inject

@InjectViewState
class TopRatedListPresenter @Inject constructor(
    private val api: MovieRatingApi
) : MvpPresenter<MovieListView>() {

    private var page = 1
    private val job = SupervisorJob()
    private val exceptionHandler =
        CoroutineExceptionHandler { _, throwable -> Log.e("EXCEPTION_HANDLER", throwable.message) }
    private val coroutineScope = CoroutineScope(Dispatchers.Main + job + exceptionHandler)

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadItems()
    }

    fun loadItems() {
        coroutineScope.launch {
            val movies = withContext(Dispatchers.IO) { api.getTopRatedMovies(page) }
            viewState.showMoreItems(movies.await().movies)
            page++
        }
    }
}