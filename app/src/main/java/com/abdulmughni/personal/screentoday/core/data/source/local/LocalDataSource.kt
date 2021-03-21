package com.abdulmughni.personal.screentoday.core.data.source.local

import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MovieNowPlayingEntity
import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MoviePopularEntity
import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MovieTopRatedEntity
import com.abdulmughni.personal.screentoday.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val movieDao: MovieDao) {
    fun getMoviePopular(): Flow<List<MoviePopularEntity>> = movieDao.getPopularMovies()
    fun getMovieTopRated(): Flow<List<MovieTopRatedEntity>> = movieDao.getTopRatedMovies()
    fun getMovieNowPlaying(): Flow<List<MovieNowPlayingEntity>> = movieDao.getNowPlayingMovies()

    suspend fun insertMoviePop(moviePopularEntity: List<MoviePopularEntity>) = movieDao.insertPopMovie(moviePopularEntity)
    suspend fun insertMovieTopRated(movieTopRatedEntity: List<MovieTopRatedEntity>) = movieDao.insertTopRatedMovie(movieTopRatedEntity)
    suspend fun insertMovieNowPlaying(movieNowPlayingEntity: List<MovieNowPlayingEntity>) = movieDao.insertNowPlayingMovie(movieNowPlayingEntity)
}