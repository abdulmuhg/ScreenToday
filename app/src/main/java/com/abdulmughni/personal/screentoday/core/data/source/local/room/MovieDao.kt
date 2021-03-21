package com.abdulmughni.personal.screentoday.core.data.source.local.room

import androidx.room.*
import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MoviePopularEntity
import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MovieNowPlayingEntity
import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MovieTopRatedEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies_popular")
    fun getPopularMovies(): Flow<List<MoviePopularEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopMovie(moviePopular: List<MoviePopularEntity>)

    @Update
    fun updatePopMovie(moviePopular: MoviePopularEntity)

    @Query("SELECT * FROM movies_now_playing")
    fun getNowPlayingMovies(): Flow<List<MovieNowPlayingEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNowPlayingMovie(movie: List<MovieNowPlayingEntity>)

    @Update
    fun updateNowPlayingMovie(movie: MovieNowPlayingEntity)

    @Query("SELECT * FROM movies_top_rated")
    fun getTopRatedMovies(): Flow<List<MovieTopRatedEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRatedMovie(movie: List<MovieTopRatedEntity>)

    @Update
    fun updateTopRatedMovie(movie: MovieTopRatedEntity)
}