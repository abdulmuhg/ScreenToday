package com.abdulmughni.personal.screentoday.core.domain.repository

import com.abdulmughni.personal.screentoday.core.data.Responses
import com.abdulmughni.personal.screentoday.core.domain.model.Movie
import com.abdulmughni.personal.screentoday.core.domain.model.MovieReview
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getPopularMovies(): Flow<Responses<List<Movie>>>
    fun getTopRatedMovies(): Flow<Responses<List<Movie>>>
    fun getNowPlayingMovies(): Flow<Responses<List<Movie>>>
    fun getMovieDetails(): Flow<Responses<Movie>>
    fun getListOfReview(): Flow<Responses<List<MovieReview>>>
    fun setMovieFavorite(movie: Movie, isFavorite: Boolean)
    fun getMovieFavorite(): Flow<List<Movie>>
}