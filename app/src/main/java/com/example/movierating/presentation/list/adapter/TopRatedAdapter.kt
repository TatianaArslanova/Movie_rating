package com.example.movierating.presentation.list.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.movierating.R
import com.example.movierating.domain.MovieDTO
import kotlinx.android.synthetic.main.li_top_rated.view.*

class TopRatedAdapter : RecyclerView.Adapter<TopRatedAdapter.TopRatedViewHolder>() {

    private val items: ArrayList<MovieDTO> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): TopRatedViewHolder =
        TopRatedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.li_top_rated, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TopRatedViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun addItems(items: List<MovieDTO>) {
        val lastIndex = this.items.lastIndex
        this.items.addAll(items)
        notifyItemRangeInserted(lastIndex, items.size)
    }

    inner class TopRatedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: MovieDTO) {
            itemView.tv_title.text = item.title
            itemView.tv_overview.text = item.overview
            Glide.with(itemView.context)
                .load(item.posterPath)
                .into(itemView.iv_image)
        }
    }
}