package com.example.movierating.presentation.list

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.movierating.data.MovieRatingApi
import com.example.movierating.presentation.list.mvp.MovieListView
import kotlinx.coroutines.*

@InjectViewState
class TopRatedListPresenter(
    private val api: MovieRatingApi
) : MvpPresenter<MovieListView>() {

    private val job = SupervisorJob()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadItems()
    }

    private fun loadItems() {
        coroutineScope.launch {
            val movies = withContext(Dispatchers.IO) { api.getTopRatedMovies() }
            viewState.showMoreItems(movies.await().movies)
        }
    }
}