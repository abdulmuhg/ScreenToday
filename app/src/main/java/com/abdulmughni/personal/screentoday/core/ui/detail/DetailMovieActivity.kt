package com.abdulmughni.personal.screentoday.core.ui.detail

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.abdulmughni.personal.screentoday.R
import com.abdulmughni.personal.screentoday.core.data.Responses
import com.abdulmughni.personal.screentoday.core.domain.model.Movie
import com.abdulmughni.personal.screentoday.core.domain.model.MovieReview
import com.abdulmughni.personal.screentoday.core.ui.MoviesAdapter
import com.abdulmughni.personal.screentoday.core.ui.ReviewAdapter
import com.abdulmughni.personal.screentoday.core.ui.favorite.FavoriteListActivity
import com.abdulmughni.personal.screentoday.core.utils.formatDate
import com.abdulmughni.personal.screentoday.databinding.ActivityDetailMovieBinding
import com.abdulmughni.personal.screentoday.databinding.BottomSheetSuccessBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMovieActivity : AppCompatActivity() {

    private val viewModel : DetailMoviesViewModel by viewModels()
    private val binding : ActivityDetailMovieBinding by lazy {
        ActivityDetailMovieBinding.inflate(layoutInflater)
    }
    private val data : Movie? by lazy {
        intent.getParcelableExtra("data")
    }
    private val reviewAdapter: ReviewAdapter by lazy {
        ReviewAdapter { item -> detailReview(item) }
    }
    private fun detailReview(movie: MovieReview) {

    }
    private var statusFavorite: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setData()
        setupAdapter()
    }

    @SuppressLint("SetTextI18n")
    private fun setData() {
        statusFavorite = data?.isFavorite!!

        with(binding) {
            if(data != null){
                tvTitleToolbar.text = data?.title
                tvTitle.text = data?.originalTitle
                tvRelease.text = if(data?.releaseDate != "") formatDate(data?.releaseDate) else "-"
                tvType.text = "Movie"
                tvRating.text = data?.popularity.toString()
                tvSerialize.text = data?.originalLanguage
                tvUserCount.text = data?.voteCount.toString() + " Users Vote"
                tvVoteAvg.text = data?.voteAverage.toString() + " Vote Average"
                tvSynopsis.text = data?.overview
                Glide.with(this@DetailMovieActivity)
                    .load("https://image.tmdb.org/t/p/w200/" + data?.posterPath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgCover)
                if (data?.adult == true) tvAdult.text = R.string.adult_sign.toString() else tvAdult.visibility = View.GONE
                checkStatusFavorite(data)
            }

            imgBack.setOnClickListener {
                finish()
            }

            btnFavorite.setOnClickListener {
                setFavorite()
            }
        }

        viewModel.getListReview(data?.id!!).observe(this, {
            when (it) {
                is Responses.Success -> {
                    getDataSuccess(it)
                }
            }
        })
    }

    private fun getDataSuccess(movie: Responses<List<MovieReview>>) {
        reviewAdapter.setData(movie.data)
    }

    private fun checkStatusFavorite(data : Movie?) {
        if(data?.isFavorite!!) {
            setDrawableIsFavorite()
        } else {
            setDrawableNotFavorite()
        }
    }
    private fun setFavorite() {
        statusFavorite = !statusFavorite
        viewModel.setFavoriteMovie(data!!, statusFavorite)
        setStatusFavorite(statusFavorite)
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            setDrawableIsFavorite()
            successDialog()
        } else {
            setDrawableNotFavorite()
        }
    }

    private fun setDrawableIsFavorite() {
        binding.btnFavorite.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.ic_baseline_favorite_24
            )
        )
    }

    private fun setDrawableNotFavorite() {
        binding.btnFavorite.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.ic_baseline_favorite_border_24
            )
        )
    }

    private fun successDialog() {
        val binding = BottomSheetSuccessBinding.inflate(layoutInflater)
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(binding.root)
        with(binding) {
            btnOk.setOnClickListener {
                try {
                    startActivity(
                        Intent(this@DetailMovieActivity, FavoriteListActivity::class.java)
                    )
                    dialog.dismiss()
                } catch (e: Exception) {
                    e.printStackTrace()
                    android.widget.Toast.makeText(
                        this@DetailMovieActivity,
                        "Module not installed!",
                        android.widget.Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        dialog.show()
    }

    private fun setupAdapter() {
        with(binding) {
            rvReview.also {
                it.adapter = reviewAdapter
                it.layoutManager = GridLayoutManager(this@DetailMovieActivity, 1)
                it.setHasFixedSize(true)
            }
        }
    }

}