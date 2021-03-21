package com.abdulmughni.personal.screentoday.core.data.source.local

import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MovieEntity
import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MovieReviewEntity
import com.abdulmughni.personal.screentoday.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val movieDao: MovieDao) {
    fun getMoviePopular(): Flow<List<MovieEntity>> = movieDao.getPopularMovies()
    fun getMovieTopRated(): Flow<List<MovieEntity>> = movieDao.getTopRatedMovies()
    fun getMovieNowPlaying(): Flow<List<MovieEntity>> = movieDao.getNowPlayingMovies()
    fun getMovieReviewList(): Flow<List<MovieReviewEntity>> = movieDao.getListMovieReview()

    suspend fun insertMovie(movieEntity: List<MovieEntity>) = movieDao.insertMovie(movieEntity)
    suspend fun insertListReview(movieReviewEntity: List<MovieReviewEntity>) = movieDao.insertReviewMovie(movieReviewEntity)

    fun getMovieFavorite(): Flow<List<MovieEntity>> = movieDao.getFavoriteMovie()
    fun setFavoriteMovie(movie: MovieEntity, isFavorite: Boolean){
        movie.isFavorite = isFavorite
        movieDao.updateMovie(movie)
    }
}