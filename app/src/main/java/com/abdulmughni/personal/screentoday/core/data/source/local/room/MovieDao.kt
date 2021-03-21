package com.abdulmughni.personal.screentoday.core.data.source.local.room

import androidx.room.*
import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies")
    fun getMovies(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovie(movie: List<MovieEntity>)

    @Update
    fun updateMovie(moviePopular: MovieEntity)

    @Query("SELECT * FROM movies where isFavorite = 1")
    fun getFavoriteMovie(): Flow<List<MovieEntity>>

//    @Query("SELECT * FROM movies_now_playing")
//    fun getNowPlayingMovies(): Flow<List<MovieNowPlayingEntity>>
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insertNowPlayingMovie(movie: List<MovieNowPlayingEntity>)
//
//    @Update
//    fun updateNowPlayingMovie(movie: MovieNowPlayingEntity)
//
//    @Query("SELECT * FROM movies_top_rated")
//    fun getTopRatedMovies(): Flow<List<MovieTopRatedEntity>>
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insertTopRatedMovie(movie: List<MovieTopRatedEntity>)
//
//    @Update
//    fun updateTopRatedMovie(movie: MovieTopRatedEntity)
}