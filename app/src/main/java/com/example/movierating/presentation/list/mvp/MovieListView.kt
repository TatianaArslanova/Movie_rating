package com.example.movierating.presentation.list.mvp

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.movierating.domain.MovieDTO

@StateStrategyType(OneExecutionStateStrategy::class)
interface MovieListView : MvpView {

    fun showMoreItems(items: List<MovieDTO>)
}