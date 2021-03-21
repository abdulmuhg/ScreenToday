package com.abdulmughni.personal.screentoday.core.ui.movie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.abdulmughni.personal.screentoday.core.domain.usecase.MovieUseCase

class MoviesViewModel @ViewModelInject constructor(private val movieUseCase: MovieUseCase): ViewModel() {
    var popularMovies = movieUseCase.getPopularMovies().asLiveData()
    var topRatedMovies = movieUseCase.getTopRatedMovies().asLiveData()
    var nowPlayingMovies = movieUseCase.getNowPlayingMovies().asLiveData()
}