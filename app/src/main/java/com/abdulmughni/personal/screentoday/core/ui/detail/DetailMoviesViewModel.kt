package com.abdulmughni.personal.screentoday.core.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.abdulmughni.personal.screentoday.core.domain.model.Movie
import com.abdulmughni.personal.screentoday.core.domain.usecase.MovieUseCase

class DetailMoviesViewModel @ViewModelInject constructor(private val movieUseCase: MovieUseCase): ViewModel() {
    fun setFavoriteMovie(movie: Movie, isFavorite: Boolean){
        movieUseCase.setMovieFavorite(movie, isFavorite)
    }
}