package com.example.movierating.presentation.list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.movierating.R
import com.example.movierating.domain.MovieDTO
import com.example.movierating.presentation.list.adapter.TopRatedAdapter
import com.example.movierating.presentation.list.mvp.MovieListView
import dagger.Lazy
import kotlinx.android.synthetic.main.fragment_list_top_rated.*
import javax.inject.Inject

class TopRatedListFragment : Fragment(), MovieListView {

    companion object {
        fun newInstance() = TopRatedListFragment()
        const val TAG = "TopRatedListFragment"
    }

    @Inject
    lateinit var presenterLazy: Lazy<TopRatedListPresenter>

    @InjectPresenter
    lateinit var presenter: TopRatedListPresenter

    @ProvidePresenter
    fun providePresenter(): TopRatedListPresenter = presenterLazy.get()

    private val adapter = TopRatedAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_list_top_rated, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        rv_top_rated.layoutManager = LinearLayoutManager(requireContext())
        rv_top_rated.adapter = adapter
    }

    override fun showMoreItems(items: List<MovieDTO>) {
        adapter.addItems(items)
    }
}