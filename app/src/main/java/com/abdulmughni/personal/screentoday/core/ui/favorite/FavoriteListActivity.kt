package com.abdulmughni.personal.screentoday.core.ui.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.abdulmughni.personal.screentoday.core.domain.model.Movie
import com.abdulmughni.personal.screentoday.core.ui.MoviesAdapter
import com.abdulmughni.personal.screentoday.core.ui.detail.DetailMovieActivity
import com.abdulmughni.personal.screentoday.databinding.ActivityFavoriteListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteListActivity : AppCompatActivity() {

    private val viewModel : FavoriteViewModel by viewModels()
    private val binding : ActivityFavoriteListBinding by lazy {
        ActivityFavoriteListBinding.inflate(layoutInflater)
    }

    private val adapter : MoviesAdapter by lazy {
        MoviesAdapter { item -> detailMovie(item)}
    }
    private fun detailMovie(movie: Movie) {
        startActivity(Intent(this, DetailMovieActivity::class.java).also {
            it.putExtra("data", movie)
        })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViewModel()
        setupAdapter()
    }
    private fun setupViewModel() {
        viewModel.favorite.observe(this, { movie ->
            adapter.setData(movie)
            setupEmptyData(movie)
        })
    }

    private fun setupAdapter() {
        with(binding) {
            rvMovie.also {
                it.adapter = adapter
                it.layoutManager = GridLayoutManager(this@FavoriteListActivity, 3)
                it.setHasFixedSize(true)
            }

            imgBack.setOnClickListener { finish() }

        }
    }

    private fun setupEmptyData (movie: List<Movie>){
        if(movie.isNotEmpty()) {
            binding.lottieEmpty.visibility = View.GONE
        } else {
            binding.lottieEmpty.visibility = View.VISIBLE
        }
    }
}