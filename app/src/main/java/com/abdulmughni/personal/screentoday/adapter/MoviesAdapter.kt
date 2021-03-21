package com.abdulmughni.personal.screentoday.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdulmughni.personal.screentoday.R
import com.abdulmughni.personal.screentoday.core.domain.model.Movie
import com.abdulmughni.personal.screentoday.databinding.AdapterMovieBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class MoviesAdapter (private val showDetail: (Movie) -> Unit) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private var data = ArrayList<Movie>()

    fun setData(popularMovies: List<Movie>?) {
        if (popularMovies == null) return
        data.clear()
        data.addAll(popularMovies)
        notifyDataSetChanged()
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.view) {
            tvType.text = "Movie"
            tvTitle.text = data[position].title
            tvRating.text = data[position].popularity.toString()
            tvTotalEpisode.text = data[position].releaseDate
            Glide.with(holder.itemView.context)
                .load("https://image.tmdb.org/t/p/w200/" + data[position].posterPath)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(imgCover)

            root.setOnClickListener {
                showDetail(data[position])
            }
        }
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        AdapterMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    class ViewHolder(val view: AdapterMovieBinding) : RecyclerView.ViewHolder(view.root)


}