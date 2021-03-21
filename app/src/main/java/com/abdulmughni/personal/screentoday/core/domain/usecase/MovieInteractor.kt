package com.abdulmughni.personal.screentoday.core.domain.usecase

import com.abdulmughni.personal.screentoday.core.data.Responses
import com.abdulmughni.personal.screentoday.core.domain.model.Movie
import com.abdulmughni.personal.screentoday.core.domain.model.MovieReview
import com.abdulmughni.personal.screentoday.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieInteractor @Inject constructor(private val movieRepository: IMovieRepository): MovieUseCase{
    override fun getPopularMovies(): Flow<Responses<List<Movie>>> = movieRepository.getPopularMovies()

    override fun getTopRatedMovies(): Flow<Responses<List<Movie>>> = movieRepository.getTopRatedMovies()

    override fun getNowPlayingMovies(): Flow<Responses<List<Movie>>> = movieRepository.getNowPlayingMovies()

    override fun getMovieDetails(id: Int): Flow<Responses<Movie>> = movieRepository.getMovieDetails()

    override fun getListOfReview(id: Int): Flow<Responses<List<MovieReview>>> = movieRepository.getListOfReview()

}