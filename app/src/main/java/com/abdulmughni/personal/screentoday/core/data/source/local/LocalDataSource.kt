package com.abdulmughni.personal.screentoday.core.data.source.local

import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MovieEntity
import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MovieNowPlayingEntity
import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MoviePopularEntity
import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MovieTopRatedEntity
import com.abdulmughni.personal.screentoday.core.data.source.local.room.MovieDao
import com.abdulmughni.personal.screentoday.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val movieDao: MovieDao) {
    fun getMoviePopular(): Flow<List<MovieEntity>> = movieDao.getPopularMovies()
    suspend fun insertMovie(movieEntity: List<MovieEntity>) = movieDao.insertMovie(movieEntity)
    fun setFavoriteMovie(movie: MovieEntity, isFavorite: Boolean){
        movie.isFavorite = isFavorite
        movieDao.updateMovie(movie)
    }
    fun getMovieFavorite(): Flow<List<MovieEntity>> = movieDao.getFavoriteMovie()

//    fun getMovieTopRated(): Flow<List<MovieTopRatedEntity>> = movieDao.getTopRatedMovies()
//    fun getMovieNowPlaying(): Flow<List<MovieNowPlayingEntity>> = movieDao.getNowPlayingMovies()
//

//    suspend fun insertMovieTopRated(movieTopRatedEntity: List<MovieTopRatedEntity>) = movieDao.insertTopRatedMovie(movieTopRatedEntity)
//    suspend fun insertMovieNowPlaying(movieNowPlayingEntity: List<MovieNowPlayingEntity>) = movieDao.insertNowPlayingMovie(movieNowPlayingEntity)

}