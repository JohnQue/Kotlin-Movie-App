package com.example.themovieapp.ui.adapter

import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.themovieapp.data.MovieItem

class MovieAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var items: ArrayList<ViewType>

    private var delegateAdapter = SparseArrayCompat<ItemAdapter>()

    private val loadingItem = object : ViewType{
        override fun getViewType() = AdapterType.LOADING
    }

    init{
        delegateAdapter.put(AdapterType.LOADING, LoadingItemAdapter())
        delegateAdapter.put(AdapterType.MOVIE, MovieItemAdapter())
        items = ArrayList()
        items.add(loadingItem)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = delegateAdapter.get(viewType)!!.onCreateViewHolder(parent)


    override fun getItemCount(): Int = items.size
    override fun getItemViewType(position: Int) = items[position].getViewType()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapter.get(getItemViewType(position))!!.onBindViewHolder(holder, items[position])
    }

    fun addMovieList(movieList: List<MovieItem>){
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        items.addAll(movieList as List<ViewType>)
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, items.size + 1)
    }

    fun clearAndAddMovieList(movieList: List<MovieItem>){
        items.clear()
        notifyItemRangeRemoved(0, getLastPosition())

        items.addAll(movieList as List<ViewType>)
        items.add(loadingItem)
        notifyItemRangeInserted(0, items.size)
    }

    fun getMovieList() : List<MovieItem> = items
        .filter{it.getViewType() == AdapterType.MOVIE}
        .map{it as MovieItem}

    private fun getLastPosition() = if(items.lastIndex == -1) 0 else items.lastIndex
}