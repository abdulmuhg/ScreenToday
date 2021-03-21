package com.abdulmughni.personal.screentoday.core.ui.favorite

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.abdulmughni.personal.screentoday.core.domain.usecase.MovieUseCase

class FavoriteViewModel @ViewModelInject constructor(private val movieUseCase: MovieUseCase): ViewModel(){
    val favorite = movieUseCase.getMovieFavorite().asLiveData()
}