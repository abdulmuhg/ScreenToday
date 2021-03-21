package com.abdulmughni.personal.screentoday.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdulmughni.personal.screentoday.R
import com.abdulmughni.personal.screentoday.core.domain.model.Movie
import com.abdulmughni.personal.screentoday.core.domain.model.MovieReview
import com.abdulmughni.personal.screentoday.databinding.AdapterMovieBinding
import com.abdulmughni.personal.screentoday.databinding.AdapterReviewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ReviewAdapter (private val showDetail: (MovieReview) -> Unit) : RecyclerView.Adapter<ReviewAdapter.ViewHolder>() {

    private var data = ArrayList<MovieReview>()

    fun setData(movieReview: List<MovieReview>?) {
        if (movieReview == null) return
        data.clear()
        data.addAll(movieReview)
        notifyDataSetChanged()
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ReviewAdapter.ViewHolder, position: Int) {
        with(holder.view) {
            author.text = data[position].author
            content.text = data[position].content
            root.setOnClickListener {
                showDetail(data[position])
            }
        }
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        AdapterReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    class ViewHolder(val view: AdapterReviewBinding) : RecyclerView.ViewHolder(view.root)



}