package com.example.themovieapp.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themovieapp.R
import com.example.themovieapp.data.MovieItem
import com.example.themovieapp.ui.adapter.MovieAdapter
import com.example.themovieapp.utils.inflate
import kotlinx.android.synthetic.main.frag_recycler.*

class MovieFragment : Fragment() {

    private val movieList by lazy { rv_movie_list } // (1)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.frag_recycler)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) { // (2)
        super.onActivityCreated(savedInstanceState)
        movieList.setHasFixedSize(true)  // lazy 접근 실행
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            movieList.layoutManager = LinearLayoutManager(context)
        }
        rv_movie_list.apply{
            setHasFixedSize(true)
            val linearLayout = LinearLayoutManager(context)
            layoutManager = linearLayout
        }

        if(rv_movie_list.adapter == null) rv_movie_list.adapter = MovieAdapter()
        if(savedInstanceState == null){
            var movieList = mutableListOf<MovieItem>()
            for(i in 1..10){
                movieList.add(
                    MovieItem(
                        1234,
                        5.0f,
                        "Test title $i",
                        "2018-01-01",
                        "https://picsum.photos/480/640?image=$i",
                        "Test Overview"
                    )
                )
            }
            (rv_movie_list.adapter as MovieAdapter).addMovieList(movieList)
        }
    }
}