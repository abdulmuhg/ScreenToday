package com.abdulmughni.personal.screentoday.core.domain.usecase

import com.abdulmughni.personal.screentoday.core.data.Responses
import com.abdulmughni.personal.screentoday.core.domain.model.Movie
import com.abdulmughni.personal.screentoday.core.domain.model.MovieReview
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getPopularMovies(): Flow<Responses<List<Movie>>>
    fun getTopRatedMovies(): Flow<Responses<List<Movie>>>
    fun getNowPlayingMovies(): Flow<Responses<List<Movie>>>
    fun getMovieDetails(id: Int): Flow<Responses<Movie>>
    fun getListOfReview(id: Int): Flow<Responses<List<MovieReview>>>
}