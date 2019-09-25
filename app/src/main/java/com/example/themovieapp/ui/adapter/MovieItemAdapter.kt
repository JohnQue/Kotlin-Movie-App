package com.example.themovieapp.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themovieapp.R
import com.example.themovieapp.data.MovieItem
import com.example.themovieapp.utils.inflate
import com.example.themovieapp.utils.loadImg
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieItemAdapter : ItemAdapter{
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return MovieViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as MovieViewHolder
        holder.bind(item as MovieItem)
    }

    inner class MovieViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.item_movie)){

        private val imgPoster = itemView.img_poster
        private val overview = itemView.tv_overview
        private val releaseDate = itemView.tv_release_date
        private val voteCount = itemView.tv_vote_count
        private val tvTitle = itemView.tv_title
        private val tvAverage = itemView.rate_vote_avg
        private val btnReverse = itemView.btn_reverse

        fun bind(item: MovieItem){
            imgPoster.loadImg(item.poster_path)
            overview.text = item.overview
            releaseDate.text = item.release_date
            voteCount.text = "${item.vote_count} 투표"
            tvTitle.text = item.title
            tvAverage.rating = item.vote_average / 2
        }
    }
}