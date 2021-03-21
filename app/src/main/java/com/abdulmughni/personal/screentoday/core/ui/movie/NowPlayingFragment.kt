package com.abdulmughni.personal.screentoday.core.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.abdulmughni.personal.screentoday.core.data.Responses
import com.abdulmughni.personal.screentoday.core.domain.model.Movie
import com.abdulmughni.personal.screentoday.core.ui.MoviesAdapter
import com.abdulmughni.personal.screentoday.core.ui.detail.DetailMovieActivity
import com.abdulmughni.personal.screentoday.core.ui.favorite.FavoriteListActivity
import com.abdulmughni.personal.screentoday.core.utils.sheetBehavior
import com.abdulmughni.personal.screentoday.databinding.BottomSheetBinding
import com.abdulmughni.personal.screentoday.databinding.FragmentNowPlayingBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NowPlayingFragment : Fragment() {
    private lateinit var behavior: BottomSheetBehavior<*>
    private val viewModel: MoviesViewModel by viewModels()

    private val binding: FragmentNowPlayingBinding by lazy {
        FragmentNowPlayingBinding.inflate(layoutInflater)
    }
    private val moviesAdapter: MoviesAdapter by lazy {
        MoviesAdapter { item -> detailMovie(item) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    private fun isLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.pgMovie.visibility = View.VISIBLE
            binding.rvMovie.visibility = View.INVISIBLE
        } else {
            binding.pgMovie.visibility = View.GONE
            binding.rvMovie.visibility = View.VISIBLE
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBottomsheet()
        setupViewModel()
        setupAdapter()
    }

    private fun detailMovie(movie: Movie) {
        startActivity(Intent(requireContext(), DetailMovieActivity::class.java).also {
            it.putExtra("data", movie)
        })
    }


    private fun setupViewModel() {
        viewModel.nowPlayingMovies.observe(viewLifecycleOwner, {
            when (it) {
                is Responses.Loading -> isLoading(true)
                is Responses.Success -> getDataSuccess(it)
                is Responses.Error -> showError()
            }
        })
    }

    private fun setupAdapter() {
        with(binding) {
            rvMovie.also {
                it.adapter = moviesAdapter
                it.layoutManager = GridLayoutManager(requireContext(), 1)
                it.setHasFixedSize(true)
            }

            imgFavorite.also {
                imgFavorite.setOnClickListener {
                    try {
                        startActivity(
                            Intent(activity, FavoriteListActivity::class.java)
                        )
                    } catch (e: Exception) {
                        e.printStackTrace()
                        Toast.makeText(
                            requireContext(),
                            "Module not installed!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    private fun getDataSuccess(movie: Responses<List<Movie>>) {
        moviesAdapter.setData(movie.data)
        isLoading(false)
    }

    private fun setupBottomsheet() {
        behavior = binding.bottomSheet.sheetBehavior()
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    private fun showError() {
        val binding = BottomSheetBinding.inflate(layoutInflater)
        val dialog = BottomSheetDialog(requireContext())
        dialog.setContentView(binding.root)
        with(binding) {
            btnOk.setOnClickListener {
                dialog.dismiss()
            }
        }

        dialog.show()
    }
}